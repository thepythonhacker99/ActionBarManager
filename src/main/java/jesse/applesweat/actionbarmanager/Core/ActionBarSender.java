package jesse.applesweat.actionbarmanager.Core;

import net.kyori.adventure.text.ComponentLike;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * <strong>THIS IS A INTERNAL CLASS. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
 * <p>
 * This class is responsible for sending
 * action bar messages
 */
public class ActionBarSender {
    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     * Sends an action bar message to a player.
     *
     * @param player   The player to send the message to
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param priority The priority of the message
     */
    public static void sendActionBarMessage(@NotNull Player player, @NotNull ComponentLike message, long duration, @NotNull MessagePriority priority) {
        RequestManager.requestActionBarMessage(player, message, duration, priority);
    }
}
