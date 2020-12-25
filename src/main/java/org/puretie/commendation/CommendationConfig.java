package org.puretie.commendation;

import com.google.gson.Gson;
import ninja.bytecode.shuriken.io.IO;

import java.io.File;
import java.io.IOException;

public class CommendationConfig
{
    private String reportName = "report";
    private static CommendationConfig g;
    private static CommendationConfig load() throws IOException
    {
        CommendationConfig c = new CommendationConfig();
        File f = Commendation.instance.getDataFile("config.json");
        if(!f.exists())
        {
            IO.writeAll(f, new Gson().toJson(c));
        }
        String s = IO.readAll(f);
        CommendationConfig d = new Gson().fromJson(s, CommendationConfig.class);
                return d;
    }

    public static CommendationConfig get()
    {
        if(g == null)
        {
            try
            {
               g = load();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return g;
    }
}
