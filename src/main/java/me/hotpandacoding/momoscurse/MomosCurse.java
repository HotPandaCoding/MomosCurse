package me.hotpandacoding.momoscurse;

import me.hotpandacoding.momoscurse.commands.SetSpawnTime;
import me.hotpandacoding.momoscurse.commands.StartPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MomosCurse extends JavaPlugin {

    private static MomosCurse plugin;

    @Override
    public void onEnable() {

        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("startPlugin").setExecutor(new StartPlugin());
        getCommand("setSpawnTime").setExecutor(new SetSpawnTime());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MomosCurse getPlugin() {
        return plugin;
    }
}
