package de.mika.sMCLobby;

import de.mika.sMCLobby.commands.GamemodeCMD;
import de.mika.sMCLobby.commands.SetSpawnCMD;
import de.mika.sMCLobby.commands.SpawnCMD;
import de.mika.sMCLobby.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("gm").setExecutor(new GamemodeCMD());
        getCommand("setspawn").setExecutor(new SetSpawnCMD(this));
        getCommand("spawn").setExecutor(new SpawnCMD(this));

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new BossbarListener(), this);
        getServer().getPluginManager().registerEvents(new NoTimeListener(), this);
        getServer().getPluginManager().registerEvents(new DoubleJumpListener(), this);
        getServer().getPluginManager().registerEvents(new VoidListener(this), this);
        Bukkit.getPluginManager().registerEvents(new NoBuildListener(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
