package jesse.applesweat.actionbarmanager.Core;

import jesse.applesweat.actionbarmanager.Utils.TimeConverter;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

/**
 * <strong>THIS IS A INTERNAL CLASS. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
 * <p>
 * This class is responsible for managing
 * the action bar requests that are made
 */
public class RequestManager {
    /**
     * Tracks the messages that are currently being
     * displayed to a player.
     */
    private static final HashMap<UUID, ActionBarMessage> messageTracker = new HashMap<>();

    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     *
     * @param player   The player to send the message to
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param priority The priority of the message
     */
    public static void requestActionBarMessage(@NotNull Player player, @NotNull ComponentLike message, long duration, @NotNull MessagePriority priority) {
        if (duration <= 0) {
            return;
        }

        ActionBarMessage currentMessage = getCurrentActionBarMessage(player.getUniqueId());

        ActionBarMessage requestAsMessage = new ActionBarMessage();
        requestAsMessage.message = message;
        requestAsMessage.sendTime = System.currentTimeMillis();
        requestAsMessage.duration = TimeConverter.ticksToMillis(duration);
        requestAsMessage.priority = priority;

        if (currentMessage == null || currentMessage.canBeOverwrittenBy(currentMessage)) {
            messageTracker.put(player.getUniqueId(), requestAsMessage);
        }
    }

    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     *
     * @param id The id to query
     * @return The last message that has been sent to this UUID
     */
    public static @Nullable ActionBarMessage getCurrentActionBarMessage(UUID id) {
        return messageTracker.get(id);
    }

    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     * Removes messages that are not displayed anymore
     * from the actionbar message tracker
     */
    public static void updateTracker() {
        messageTracker.entrySet().removeIf(e -> !e.getValue().isDisplayed());
    }
}
