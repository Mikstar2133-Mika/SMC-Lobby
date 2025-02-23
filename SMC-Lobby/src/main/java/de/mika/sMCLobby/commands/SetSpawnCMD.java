package de.mika.sMCLobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.bukkit.configuration.file.FileConfiguration;
import de.mika.sMCLobby.Main;

public class SetSpawnCMD implements CommandExecutor {

    private final Main plugin;

    public SetSpawnCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return true;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();
        Vector direction = loc.getDirection();
        FileConfiguration config = plugin.getConfig();

        config.set("spawn.world", loc.getWorld().getName());
        config.set("spawn.x", loc.getX());
        config.set("spawn.y", loc.getY());
        config.set("spawn.z", loc.getZ());
        config.set("spawn.yaw", loc.getYaw());
        config.set("spawn.pitch", loc.getPitch());
        config.set("spawn.direction.x", direction.getX());
        config.set("spawn.direction.y", direction.getY());
        config.set("spawn.direction.z", direction.getZ());

        plugin.saveConfig();
        player.sendMessage("§9§lSUCHTMC§8・§7Du hast den neuen §eSpawnpunkt §7festgelegt.");

        return true;
    }
}
