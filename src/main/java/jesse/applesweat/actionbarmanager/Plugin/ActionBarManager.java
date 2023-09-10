package jesse.applesweat.actionbarmanager.Plugin;

import jesse.applesweat.actionbarmanager.Core.ActionBarDisplayManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;

/**
 * {@code ActionBarManager} is a plugin for
 * easily managing the action bar that is
 * sent to players.
 * <p>
 * It has features such as
 * setting the duration of messages, choosing
 * their priority and more!
 *
 * @see jesse.applesweat.actionbarmanager.API.ActionBarAPI
 */
public final class ActionBarManager extends JavaPlugin {
    /**
     * The internal instance of the {@code ActionBarManager} plugin
     */
    @Getter
    private static @Nullable ActionBarManager instance = null;

    @Override
    public void onEnable() {
        instance = this;

        ActionBarDisplayManager.startSending();
    }

    @Override
    public void onDisable() {
        ActionBarDisplayManager.stopSending();

        instance = null;
    }
}
