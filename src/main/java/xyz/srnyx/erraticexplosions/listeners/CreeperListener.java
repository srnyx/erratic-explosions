package xyz.srnyx.erraticexplosions.listeners;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;

import xyz.srnyx.erraticexplosions.ErraticExplosions;


public class CreeperListener implements AnnoyingListener {
    @NotNull
    private final ErraticExplosions plugin;

    @Override
    public @NotNull ErraticExplosions getPlugin() {
        return plugin;
    }

    @Contract(pure = true)
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
        if (entity instanceof Creeper) {
            if (!plugin.config.creepers) {
                unregister();
                return;
            }
            final Creeper creeper = (Creeper) entity;
            creeper.setExplosionRadius((int) plugin.config.getPower());
            creeper.setMaxFuseTicks(plugin.config.getFuse());
        }
    }
}
