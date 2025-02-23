package de.mika.sMCLobby.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.mika.sMCLobby.Main;

public class SpawnCMD implements CommandExecutor {

    private final Main plugin;

    public SpawnCMD(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return true;
        }

        Player player = (Player) sender;

        if (plugin.getConfig().get("spawn") == null) {
            player.sendMessage("§9§lSUCHTMC§8・§cDer Spawnpunkt wurde noch nicht gesetzt!");
            return true;
        }

        World world = Bukkit.getWorld(plugin.getConfig().getString("spawn.world"));
        double x = plugin.getConfig().getDouble("spawn.x");
        double y = plugin.getConfig().getDouble("spawn.y");
        double z = plugin.getConfig().getDouble("spawn.z");
        float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
        float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");

        Location spawnLocation = new Location(world, x, y, z, yaw, pitch);
        player.teleport(spawnLocation);
        player.sendMessage("§9§lSUCHTMC§8・§7Du wurdest zum §eSpawn §7teleportiert.");

        return true;
    }
}
