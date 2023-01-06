package xyz.srnyx.erraticexplosions.commands;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.AnnoyingMessage;
import xyz.srnyx.annoyingapi.command.AnnoyingCommand;
import xyz.srnyx.annoyingapi.command.AnnoyingSender;

import xyz.srnyx.erraticexplosions.ErraticExplosions;


public class ReloadCommand implements AnnoyingCommand {
    @NotNull private final ErraticExplosions plugin;

    @Contract(pure = true)
    public ReloadCommand(@NotNull ErraticExplosions plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull ErraticExplosions getPlugin() {
        return plugin;
    }

    @Override
    public @NotNull String getName() {
        return "eereload";
    }

    @Override
    public @Nullable String getPermission() {
        return "ee.command.reload";
    }

    @Override
    public void onCommand(@NotNull AnnoyingSender sender) {
        plugin.reloadPlugin();
        new AnnoyingMessage(plugin, "command.reload").send(sender);
    }
}
