package me.hotpandacoding.momoscurse.commands;

import me.hotpandacoding.momoscurse.MomosCurse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnTime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {

            if(args.length > 0){
                MomosCurse.getPlugin().getConfig().set("SpawnTime" , Integer.parseInt(args[0]));
                p.sendMessage(ChatColor.AQUA + "The time changed to " + args[0]);
                MomosCurse.getPlugin().saveConfig();
                Bukkit.getPluginManager().disablePlugin(MomosCurse.getPlugin());
                Bukkit.getPluginManager().enablePlugin(MomosCurse.getPlugin());

            }else {
                p.sendMessage(ChatColor.RED + "you need to give the command and argument");
            }

        }
        return true;
    }
}
