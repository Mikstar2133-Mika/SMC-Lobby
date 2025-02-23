package de.mika.sMCLobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class NoBuildListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            event.setCancelled(true);
        } else if (event.getPlayer().getGameMode().equals(GameMode.ADVENTURE)){
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            event.setCancelled(true);
        } else if (event.getPlayer().getGameMode().equals(GameMode.ADVENTURE)){
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }


}
