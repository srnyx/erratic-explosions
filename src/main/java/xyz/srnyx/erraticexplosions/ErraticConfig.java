package xyz.srnyx.erraticexplosions;

import org.bukkit.configuration.ConfigurationSection;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.file.AnnoyingResource;

import java.util.Random;


public class ErraticConfig {
    @NotNull private static final Random RANDOM = new Random();

    @NotNull private final AnnoyingResource config;

    public final boolean tnt;
    public final boolean creepers;
    public final boolean otherExplosives;
    @NotNull public final Fuse fuse;
    @NotNull public final Power power;

    public ErraticConfig(@NotNull ErraticExplosions plugin) {
        config = new AnnoyingResource(plugin, "config.yml");
        tnt = config.getBoolean("tnt", true);
        creepers = config.getBoolean("creepers", true);
        otherExplosives = config.getBoolean("other-explosives", true);
        fuse = new Fuse();
        power = new Power();
    }

    public class Fuse {
        private int min = 20;
        private int max = 100;

        public Fuse() {
            final ConfigurationSection section = config.getConfigurationSection("fuse");
            if (section != null) {
                min = section.getInt("min", min);
                max = section.getInt("max", max);
            }
            max = max - min + 1;
        }

        public int getRandom() {
        return RANDOM.nextInt(max) + min;
    }
    }

    public class Power {
        private float min = 4.0f;
        private float max = 4.0f;

        public Power() {
            final ConfigurationSection section = config.getConfigurationSection("power");
            if (section != null) {
                min = (float) section.getDouble("min", min);
                max = (float) section.getDouble("max", max);
            }
            max = max - min + 1;
        }

        public float getRandom() {
        return (RANDOM.nextFloat() * max) + min;
    }
    }
}
