package org.puretie.commendation;

import lombok.Getter;
import ninja.bytecode.shuriken.bukkit.command.Command;
import ninja.bytecode.shuriken.bukkit.plugin.Control;
import ninja.bytecode.shuriken.bukkit.plugin.Controller;
import ninja.bytecode.shuriken.bukkit.plugin.Instance;
import ninja.bytecode.shuriken.bukkit.plugin.ShurikenPlugin;
import ninja.bytecode.shuriken.bukkit.util.text.C;
import ninja.bytecode.shuriken.bukkit.util.text.TXT;
import org.puretie.commendation.commands.CommandCommendation;

public class Commendation extends ShurikenPlugin {
    @Instance
    public static Commendation instance;

    @Getter
    @Control
    private DataController dc;

    @Command
    private CommandCommendation cc;

    @Override
    public void start()
    {

    }

    @Override
    public void stop()
    {

    }

    @Override
    public String getTag(String subTag) {
        return TXT.makeTag(C.DARK_GRAY, C.BLUE, C.DARK_GRAY, C.GRAY, "Commendation");
    }
}
