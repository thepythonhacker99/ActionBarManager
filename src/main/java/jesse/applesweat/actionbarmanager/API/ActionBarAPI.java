package jesse.applesweat.actionbarmanager.API;

import jesse.applesweat.actionbarmanager.Core.ActionBarSender;
import jesse.applesweat.actionbarmanager.Core.MessagePriority;
import jesse.applesweat.actionbarmanager.Plugin.ActionBarManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

/**
 * This is the API for the {@code ActionBarManager} plugin
 */
@SuppressWarnings("unused")
public class ActionBarAPI {
    /**
     * Get the {@link ActionBarManager} plugin instance,
     * may be {@code null}.
     *
     * @return The {@link ActionBarManager} plugin instance,
     * {@code null} if {@link ActionBarManager} wasn't enabled.
     */
    public static @Nullable ActionBarManager getPlugin() {
        return ActionBarManager.getInstance();
    }

    /**
     * Send an action bar message to {@code players}
     * for <strong>2 seconds</strong> with {@link MessagePriority#defaultPriority()}.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message The message to send
     * @param players The target players to send. Leave empty for all players online
     * @see #sendActionBar(ComponentLike message, Player...)
     */
    public static void sendActionBar(@NotNull String message, Player... players) {
        sendActionBar(message, 2 * 20L, MessagePriority.defaultPriority(), players);
    }

    /**
     * Send an action bar message to all {@code players}
     * for {@code duration} ticks with
     * {@link MessagePriority#defaultPriority()}.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(ComponentLike, long, Player...)
     */
    public static void sendActionBar(@NotNull String message, long duration, Player... players) {
        sendActionBar(message, duration, MessagePriority.defaultPriority(), players);
    }

    /**
     * Send an action bar message to {@code players}
     * for <strong>2 seconds</strong> with {@code priority} priority.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param priority The priority of the message
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(ComponentLike, MessagePriority, Player...)
     */
    public static void sendActionBar(@NotNull String message, @NotNull MessagePriority priority, Player... players) {
        sendActionBar(message, 2 * 20L, priority, players);
    }

    /**
     * Send an action bar message to {@code players}
     * for {@code duration} ticks with {@code priority} priority.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param priority The priority of the message
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(ComponentLike, long, MessagePriority, Player...)
     */
    public static void sendActionBar(@NotNull String message, long duration, @NotNull MessagePriority priority, Player... players) {
        sendActionBar(Component.text(message), duration, priority, players);
    }

    /**
     * Send an action bar message to {@code players}
     * for <strong>2 seconds</strong> with {@link MessagePriority#defaultPriority()}.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message The message to send
     * @param players The target players to send. Leave empty for all players online
     * @see #sendActionBar(String, Player...)
     */
    public static void sendActionBar(@NotNull ComponentLike message, Player... players) {
        sendActionBar(message, 2 * 20L, MessagePriority.defaultPriority(), players);
    }

    /**
     * Send an action bar message to all players
     * for <strong>duration</strong> ticks.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(String, long, Player...)
     */
    public static void sendActionBar(@NotNull ComponentLike message, long duration, Player... players) {
        sendActionBar(message, duration, MessagePriority.defaultPriority(), players);
    }

    /**
     * Send an action bar message to {@code players}
     * for <strong>2 seconds</strong> with {@code priority} priority.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param priority The priority of the message
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(String, MessagePriority, Player...)
     */
    public static void sendActionBar(@NotNull ComponentLike message, @NotNull MessagePriority priority, Player... players) {
        sendActionBar(message, 2 * 20L, priority, players);
    }

    /**
     * Send an action bar message to {@code players}
     * for {@code duration} ticks with {@code priority} priority.
     * The message won't be sent if there is
     * already another message that is being
     * displayed with a higher <strong>priority</strong>.
     * It will override the current message if it is of
     * lower <strong>priority</strong>.
     *
     * @param message  The message to send
     * @param duration The duration of the message in ticks
     * @param priority The priority of the message
     * @param players  The target players to send. Leave empty for all players online
     * @see #sendActionBar(String, long, MessagePriority, Player...)
     */
    public static void sendActionBar(@NotNull ComponentLike message, long duration, @NotNull MessagePriority priority, Player... players) {
        if (players.length == 0) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                ActionBarSender.sendActionBarMessage(player, message, duration, priority);
            });
        } else {
            for (Player player : players) {
                ActionBarSender.sendActionBarMessage(player, message, duration, priority);
            }
        }
    }
}
