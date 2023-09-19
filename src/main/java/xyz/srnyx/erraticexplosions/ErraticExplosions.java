package xyz.srnyx.erraticexplosions;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;
import xyz.srnyx.annoyingapi.PluginPlatform;

import xyz.srnyx.erraticexplosions.commands.ReloadCommand;
import xyz.srnyx.erraticexplosions.listeners.CreeperListener;
import xyz.srnyx.erraticexplosions.listeners.ExplosiveListener;
import xyz.srnyx.erraticexplosions.listeners.TNTListener;

import static xyz.srnyx.erraticexplosions.reflection.org.bukkit.entity.RefCreeper.*;


public class ErraticExplosions extends AnnoyingPlugin {
    public ErraticConfig config;
    @NotNull private final TNTListener tntListener = new TNTListener(this);
    @NotNull private final CreeperListener creeperListener = new CreeperListener(this);
    @NotNull private final ExplosiveListener explosiveListener = new ExplosiveListener(this);

    public ErraticExplosions() {
        options
                .pluginOptions(pluginOptions -> pluginOptions.updatePlatforms(
                        PluginPlatform.modrinth("erratic-explosions"),
                        PluginPlatform.hangar(this, "srnyx"),
                        PluginPlatform.spigot("107234")))
                .bStatsOptions(bStatsOptions -> bStatsOptions.id(18859))
                .registrationOptions.commandsToRegister(new ReloadCommand(this));
    }

    @Override
    public void enable() {
        reload();
    }

    @Override
    public void reload() {
        config = new ErraticConfig(this);
        tntListener.setRegistered(config.tnt);
        creeperListener.setRegistered(config.creepers && CREEPER_SET_MAX_FUSE_TICKS != null && CREEPER_SET_EXPLOSION_RADIUS != null);
        explosiveListener.setRegistered(config.otherExplosives);
    }
}
