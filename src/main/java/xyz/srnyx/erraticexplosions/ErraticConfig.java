package xyz.srnyx.erraticexplosions;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.file.AnnoyingResource;

import java.util.Random;


public class ErraticConfig {
    @NotNull private final Random random = new Random();

    public boolean tnt;
    public boolean creepers;
    public boolean otherExplosives;
    private final float powerMin;
    private final float powerMax;
    private final int fuseMin;
    private final int fuseMax;

    public ErraticConfig(@NotNull ErraticExplosions plugin) {
        final AnnoyingResource config = new AnnoyingResource(plugin, "config.yml");

        tnt = config.getBoolean("tnt");
        creepers = config.getBoolean("creepers");
        otherExplosives = config.getBoolean("other-explosives");
        powerMin = (float) config.getDouble("power.min");
        powerMax = (float) config.getDouble("power.max") - powerMin + 1;
        fuseMin = config.getInt("fuse.min");
        fuseMax = config.getInt("fuse.max") - fuseMin + 1;
    }

    public float getPower() {
        return (random.nextFloat() * powerMax) + powerMin;
    }

    public int getFuse() {
        return random.nextInt(fuseMax) + fuseMin;
    }
}
