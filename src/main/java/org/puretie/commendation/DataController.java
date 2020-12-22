package org.puretie.commendation;

import com.google.gson.Gson;
import ninja.bytecode.shuriken.SVC;
import ninja.bytecode.shuriken.Shuriken;
import ninja.bytecode.shuriken.bukkit.host.ShurikenAPIPlugin;
import ninja.bytecode.shuriken.bukkit.host.control.MojangProfileController;
import ninja.bytecode.shuriken.bukkit.plugin.Controller;
import ninja.bytecode.shuriken.bukkit.util.reflection.V;
import ninja.bytecode.shuriken.collections.KMap;
import ninja.bytecode.shuriken.io.IO;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataController extends Controller
{

    private KMap<UUID, CommendData> k = new KMap<>();

    public CommendData getCommendationFromUUID(UUID u)
    {
        if(k.containsKey(u))
        {
            return k.get(u);
        }
        CommendData cd = load(u);

        k.put(u,cd);
        return cd;
    }

    public UUID getUUID(String s)
    {
        Player p = Bukkit.getServer().getPlayer(s);
        if(p != null)
        {
            return p.getUniqueId();
        }

        MojangProfileController c = new V(ShurikenAPIPlugin.p).get("mojangProfileController");
        return c.getOnlineUUID(s);
    }

    private CommendData load(UUID u)
    {
        File f = getFile(u);
        if(f.exists())
        {
            try
            {
                return new Gson().fromJson(IO.readAll(f), CommendData.class);
            }
            catch(Throwable e)
            {

            }
        }

        return new CommendData();
    }

    public void saveNow()
    {
        for(UUID i: k.k())
        {
            CommendData d = k.get(i);
            File f = getFile(i);
            try
            {
                IO.writeAll(f, new Gson().toJson(d));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public File getFile(UUID u)
    {
        return Commendation.instance.getDataFile("data", u.toString() + ".json");
    }

    @Override
    public void start()
    {

    }

    @Override
    public void stop()
    {
        saveNow();
    }

    @Override
    public void tick()
    {

    }
}
