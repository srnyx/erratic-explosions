package xyz.srnyx.erraticexplosions.reflection.org.bukkit.entity;

import org.bukkit.entity.Creeper;

import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.utility.ReflectionUtility;

import java.lang.reflect.Method;


/**
 * org.bukkit.entity.Creeper
 */
public class RefCreeper {
    /**
     * 1.12.2+ org.bukkit.entity.Creeper.setMaxFuseTicks(int)
     */
    @Nullable public static final Method CREEPER_SET_MAX_FUSE_TICKS = ReflectionUtility.getMethod(1, 12, 2, Creeper.class, "setMaxFuseTicks", int.class);

    /**
     * 1.12.2+ org.bukkit.entity.Creeper.setExplosionRadius(int)
     */
    @Nullable public static final Method CREEPER_SET_EXPLOSION_RADIUS = ReflectionUtility.getMethod(1, 12, 2, Creeper.class, "setExplosionRadius", int.class);
}
