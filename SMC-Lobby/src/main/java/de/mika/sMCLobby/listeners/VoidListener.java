package de.mika.sMCLobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import de.mika.sMCLobby.Main;

public class VoidListener implements Listener {

    private final Main plugin;

    public VoidListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFallIntoVoid(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() < -64) {
            if (plugin.getConfig().get("spawn") != null) {
                World world = Bukkit.getWorld(plugin.getConfig().getString("spawn.world"));
                double x = plugin.getConfig().getDouble("spawn.x");
                double y = plugin.getConfig().getDouble("spawn.y");
                double z = plugin.getConfig().getDouble("spawn.z");
                float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
                float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");

                Location spawnLocation = new Location(world, x, y, z, yaw, pitch);
                player.teleport(spawnLocation);
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
            }
        }
    }
}
