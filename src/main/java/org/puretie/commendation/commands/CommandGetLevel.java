package org.puretie.commendation.commands;

import ninja.bytecode.shuriken.bukkit.command.ShurikenCommand;
import ninja.bytecode.shuriken.bukkit.command.ShurikenSender;
import ninja.bytecode.shuriken.bukkit.plugin.ShurikenPlugin;
import org.puretie.commendation.CommendData;
import org.puretie.commendation.CommendLog;
import org.puretie.commendation.Commendation;

import java.util.UUID;

public class CommandGetLevel extends ShurikenCommand
{
    public CommandGetLevel()
    {
        super("level", "l");
    }

    @Override
    public boolean handle(ShurikenSender sender, String[] args)
    {
        UUID u = Commendation.instance.getDc().getUUID(args[0]);
        if(u == null)
        {
            sender.sendMessage("Could not find user.");
            return true;
        }
        int x = Commendation.instance.getDc().getCommendationFromUUID(u).getCommendationLevel();
        sender.sendMessage("User " + args[0] + " has a commendation level of " + x);
        return true;
    }
}
