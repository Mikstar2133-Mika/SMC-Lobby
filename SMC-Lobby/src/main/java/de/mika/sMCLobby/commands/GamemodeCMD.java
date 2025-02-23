package de.mika.sMCLobby.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {
    //gm 0, 1, 2, 3
    //gm 0 - Survival
    //gm 1 - Creative
    //gm 2 - Adventure
    //gm 3 - Spectator
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
            return false;
        }
        Player player = (Player) sender;
        String prefix = "§9§lSUCHTMC§8・§7";
        String noperms = "§cDazu hast du keine Berechtigung!";
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("0")){
                if (player.hasPermission("lobby.command.gamemode.0")){
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(prefix + "§7Du bist in den §eÜberlebenmodus §7gegangen.");
                }else {
                    player.sendMessage(prefix + noperms);
                }

            }else if (args[0].equalsIgnoreCase("1")){
                if (player.hasPermission("lobby.command.gamemode.1")){
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(prefix + "§7Du bist in den §eKreativmodus §7gegangen.");
                } else {
                    player.sendMessage(prefix + noperms);
                }

            }else if (args[0].equalsIgnoreCase("2")){
                if (player.hasPermission("lobby.command.gamemode.2")){
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(prefix + "§7Du bist in den §eAdventuremodus §7gegangen.");
                } else {
                    player.sendMessage(prefix + noperms);
                }

            }else if (args[0].equalsIgnoreCase("3")){
                if (player.hasPermission("lobby.command.gamemode.3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(prefix + "§7Du bist in den §eBeobachtungsmodus §7gegangen.");
                } else {
                    player.sendMessage(prefix + noperms);
                }
            } else {
                player.sendMessage(prefix + ChatColor.RED + "Nutze: /gm <0,1,2,3>");
            }

        }else {
            player.sendMessage(prefix + ChatColor.RED + "Nutze: /gm <0,1,2,3>");
        }
        return false;
    }
}
