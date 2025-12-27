package api.mcmeta.banword;

import org.bukkit.plugin.java.JavaPlugin;

public final class Banwordmeta extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        System.out.println("[BanWord] загружен");
    }

    @Override
    public void onDisable() {
        System.out.println("[BanWord] выключен");
    }
}