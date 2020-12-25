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
        commend(reason, 1);
    }

    public void commend(String reason, int points)
    {
        log.add(new CommendLog(M.ms(), reason, points));
    }

    public int getCommendationLevel()
    {
        int z = 0;
        for(CommendLog i : log)
        {
            z += i.getPoints();
        }
        return z;
    }
}
