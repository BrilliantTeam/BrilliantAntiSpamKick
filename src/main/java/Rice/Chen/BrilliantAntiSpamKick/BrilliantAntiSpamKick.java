package Rice.Chen.BrilliantAntiSpamKick;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BrilliantAntiSpamKick extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("BrilliantAntiSpamKick on Enable");
    }

    @Override
    public void onDisable() {
        getLogger().info("BrilliantAntiSpamKick on Disable");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerKick(PlayerKickEvent event) {
        if (event.getReason().toLowerCase().contains("spamming")) {
            event.setCancelled(true);
            getLogger().info(event.getPlayer().getName() + " 可能正在洗版。");
        }
    }
}