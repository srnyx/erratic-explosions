package xyz.srnyx.erraticexplosions;

import org.bukkit.ChatColor;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;

import xyz.srnyx.erraticexplosions.commands.ReloadCommand;
import xyz.srnyx.erraticexplosions.listeners.CreeperListener;
import xyz.srnyx.erraticexplosions.listeners.ExplosiveListener;
import xyz.srnyx.erraticexplosions.listeners.TNTListener;


public class ErraticExplosions extends AnnoyingPlugin {
    public ErraticConfig config;

    public ErraticExplosions() {
        super();

        // Options
        options.colorLight = ChatColor.YELLOW;
        options.colorDark = ChatColor.GOLD;
        options.commands.add(new ReloadCommand(this));
    }

    @Override
    public void enable() {
        reload();
    }

    @Override
    public void reload() {
        config = new ErraticConfig(this);
        if (config.tnt) new TNTListener(this).register();
        if (config.creepers) new CreeperListener(this).register();
        if (config.otherExplosives) new ExplosiveListener(this).register();
    }
}
