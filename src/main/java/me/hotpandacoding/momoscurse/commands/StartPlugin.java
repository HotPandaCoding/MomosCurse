package me.hotpandacoding.momoscurse.commands;

import me.hotpandacoding.momoscurse.MomosCurse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vindicator;
import org.bukkit.scheduler.BukkitScheduler;

import static org.bukkit.Bukkit.getServer;

public class StartPlugin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            player.sendMessage(ChatColor.YELLOW + "The Plugin started");

            BukkitScheduler scheduler = getServer().getScheduler();
            scheduler.scheduleSyncRepeatingTask(MomosCurse.getPlugin(), new Runnable() {
                int count = 0;

                @Override
                public void run() {
                    Location loc = player.getLocation();
                    System.out.println("The player location is " + loc);
                    World myWorld = Bukkit.getWorld("world");

                    if (count == 0) {
                        Evoker evoker = (Evoker) myWorld.spawnEntity(loc, EntityType.EVOKER);
                        count++;
                    } else {
                        Vindicator vindicator = (Vindicator) myWorld.spawnEntity(loc, EntityType.VINDICATOR);
                        count--;
                    }
                }
            }, 0L, ((MomosCurse.getPlugin().getConfig().getInt("SpawnTime"))*20));
        }

        return true;
    }
}
