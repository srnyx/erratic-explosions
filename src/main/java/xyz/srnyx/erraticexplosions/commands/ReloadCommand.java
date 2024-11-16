package xyz.srnyx.erraticexplosions.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.command.AnnoyingCommand;
import xyz.srnyx.annoyingapi.command.AnnoyingSender;
import xyz.srnyx.annoyingapi.message.AnnoyingMessage;

import xyz.srnyx.erraticexplosions.ErraticExplosions;


public class ReloadCommand extends AnnoyingCommand {
    @NotNull private final ErraticExplosions plugin;

    public ReloadCommand(@NotNull ErraticExplosions plugin) {
        this.plugin = plugin;
    }

    @Override @NotNull
    public ErraticExplosions getAnnoyingPlugin() {
        return plugin;
    }

    @Override @NotNull
    public String getName() {
        return "eereload";
    }

    @Override @Nullable
    public String getPermission() {
        return "ee.command.reload";
    }

    @Override
    public void onCommand(@NotNull AnnoyingSender sender) {
        plugin.reloadPlugin();
        new AnnoyingMessage(plugin, "command.reload").send(sender);
    }
}
