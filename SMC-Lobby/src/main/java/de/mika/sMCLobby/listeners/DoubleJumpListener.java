package de.mika.sMCLobby.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;

public class DoubleJumpListener implements Listener {

    private final Set<Player> doubleJumpCooldown = new HashSet<>();

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();

        if (player.getGameMode().toString().equals("CREATIVE")) {
            return;
        }

        if (!player.getAllowFlight()) {
            return;
        }

        event.setCancelled(true);
        player.setAllowFlight(false);

        Location location = player.getLocation();
        Vector direction = location.getDirection().normalize();
        Vector boost = direction.multiply(2.3).setY(0.7);
        player.setVelocity(boost);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.isOnGround() && !doubleJumpCooldown.contains(player) && !player.getGameMode().toString().equals("CREATIVE")) {
            player.setAllowFlight(true);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        doubleJumpCooldown.remove(event.getPlayer());
    }
}
