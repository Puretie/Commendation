package org.puretie.commendation.commands;

import ninja.bytecode.shuriken.bukkit.command.ShurikenCommand;
import ninja.bytecode.shuriken.bukkit.command.ShurikenSender;
import ninja.bytecode.shuriken.collections.KList;
import org.puretie.commendation.Commendation;

import java.util.UUID;

public class CommandReport extends ShurikenCommand
{
    public CommandReport()
    {
        super("", "r", "uncommend");
    }

    @Override
    public boolean handle(ShurikenSender sender, String[] args)
    {
        KList<String> s = new KList<>(args);
        String u = s.pop();
        UUID t = Commendation.instance.getDc().getUUID(u);
        if(t == null)
        {
            sender.sendMessage("Who is " + u + "?");
            return true;
        }

        String reason = s.toString(" ");
        Commendation.instance.getDc().getCommendationFromUUID(t).commend(reason, -1);
        sender.sendMessage("Report sent!");
        return true;
    }
}
