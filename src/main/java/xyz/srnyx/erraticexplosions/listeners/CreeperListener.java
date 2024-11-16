package xyz.srnyx.erraticexplosions.listeners;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;
import xyz.srnyx.annoyingapi.AnnoyingPlugin;

import xyz.srnyx.erraticexplosions.ErraticExplosions;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

import static xyz.srnyx.erraticexplosions.reflection.org.bukkit.entity.RefCreeper.CREEPER_SET_EXPLOSION_RADIUS;
import static xyz.srnyx.erraticexplosions.reflection.org.bukkit.entity.RefCreeper.CREEPER_SET_MAX_FUSE_TICKS;


public class CreeperListener extends AnnoyingListener {
    @NotNull private final ErraticExplosions plugin;

    @Override @NotNull
    public ErraticExplosions getAnnoyingPlugin() {
        return plugin;
    }

    public CreeperListener(@NotNull ErraticExplosions plugin) {
        this.plugin = plugin;
    }

    /**
     * Called when a creature is spawned into a world.
     * If a Creature Spawn event is cancelled, the creature will not spawn.
     */
    @EventHandler
    public void onCreatureSpawn(@NotNull CreatureSpawnEvent event) {
        final Entity entity = event.getEntity();
        if (CREEPER_SET_EXPLOSION_RADIUS == null || CREEPER_SET_MAX_FUSE_TICKS == null || !(entity instanceof Creeper)) return;
        final Creeper creeper = (Creeper) entity;
        try {
            CREEPER_SET_EXPLOSION_RADIUS.invoke(creeper, (int) plugin.config.getPower());
            CREEPER_SET_MAX_FUSE_TICKS.invoke(creeper, plugin.config.getFuse());
        } catch (final IllegalAccessException | InvocationTargetException e) {
            AnnoyingPlugin.log(Level.WARNING, "Failed to set creeper explosion power/fuse", e);
        }
    }
}
