package xyz.srnyx.erraticexplosions.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;

import xyz.srnyx.erraticexplosions.ErraticExplosions;


public class ExplosiveListener implements AnnoyingListener {
    @NotNull
    private final ErraticExplosions plugin;

    @Override
    public @NotNull ErraticExplosions getPlugin() {
        return plugin;
    }

    @Contract(pure = true)
    public ExplosiveListener(@NotNull ErraticExplosions plugin) {
        this.plugin = plugin;
    }

    /**
     * Called when an entity has made a decision to explode.
     */
    @EventHandler
    public void onExplosionPrime(@NotNull ExplosionPrimeEvent event) {
        final Entity entity = event.getEntity();
        if (entity instanceof Explosive && !(entity instanceof TNTPrimed)) {
            if (!plugin.config.otherExplosives) {
                unregister();
                return;
            }
            event.setRadius(plugin.config.getPower());
        }
    }
}
