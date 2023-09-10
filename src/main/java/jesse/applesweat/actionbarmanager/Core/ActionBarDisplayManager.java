package jesse.applesweat.actionbarmanager.Core;

import jesse.applesweat.actionbarmanager.Plugin.ActionBarManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.annotation.Nullable;

/**
 * <strong>THIS IS A INTERNAL CLASS. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
 * <p>
 * This class is responsible for sending the
 * actual action bar text to the player
 */
public class ActionBarDisplayManager {
    private static @Nullable BukkitTask actionBarSendTask = null;

    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     * Starts sending the actionbar to players
     */
    public static void startSending() {
        if (actionBarSendTask != null) return;
        createSendTask();
    }

    /**
     * <strong>THIS IS A INTERNAL METHOD. PLEASE USE THE {@link jesse.applesweat.actionbarmanager.API.ActionBarAPI API}!</strong>
     * <p>
     * Stops sending the actionbar to players
     */
    public static void stopSending() {
        if (actionBarSendTask == null) return;

        actionBarSendTask.cancel();
        actionBarSendTask = null;
    }

    /**
     * Creates the task that sends the actionbar to the players
     */
    private static void createSendTask() {
        ActionBarManager plugin = ActionBarManager.getInstance();
        if (plugin == null) return;

        actionBarSendTask = new BukkitRunnable() {
            @Override
            public void run() {
                RequestManager.updateTracker();

                for (Player player : Bukkit.getOnlinePlayers()) {
                    ActionBarMessage message = RequestManager.getCurrentActionBarMessage(player.getUniqueId());
                    if (message == null) continue;

                    player.sendActionBar(message.message);
                }
            }
        }.runTaskTimer(
                plugin,
                0,
                0
        );
    }
}
