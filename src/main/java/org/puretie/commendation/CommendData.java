package org.puretie.commendation;

import lombok.Data;
import ninja.bytecode.shuriken.collections.KList;
import ninja.bytecode.shuriken.math.M;

@Data
public class CommendData
{
    private KList<CommendLog> log = new KList<>();


    public void commend()
    {
        commend("");
    }

    public void commend(String reason)
    {
        log.add(new CommendLog(M.ms(), reason));
    }

    public int getCommendationLevel()
    {
        return log.size();
    }
}
