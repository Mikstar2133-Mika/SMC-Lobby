package de.mika.sMCLobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BossbarListener implements Listener {

    private final BossBar bossBar;

    public BossbarListener() {
        this.bossBar = Bukkit.createBossBar("§9§lSUCHTMC", BarColor.BLUE, BarStyle.SOLID);
        this.bossBar.setProgress(1.0); // Immer voll
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        bossBar.addPlayer(player);
    }
}
