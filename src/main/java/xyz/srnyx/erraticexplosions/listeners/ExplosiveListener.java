package xyz.srnyx.erraticexplosions.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;

import xyz.srnyx.erraticexplosions.ErraticExplosions;


public class ExplosiveListener extends AnnoyingListener {
    @NotNull private final ErraticExplosions plugin;

    @Override @NotNull
    public ErraticExplosions getAnnoyingPlugin() {
        return plugin;
    }

    public ExplosiveListener(@NotNull ErraticExplosions plugin) {
        this.plugin = plugin;
    }

    /**
     * Called when an entity has made a decision to explode.
     */
    @EventHandler
    public void onExplosionPrime(@NotNull ExplosionPrimeEvent event) {
        final Entity entity = event.getEntity();
        if (entity instanceof Explosive && !(entity instanceof TNTPrimed)) event.setRadius(plugin.config.getPower());
    }
}
