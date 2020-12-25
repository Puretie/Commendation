package org.puretie.commendation;

import lombok.AllArgsConstructor;
import lombok.Data;
import ninja.bytecode.shuriken.math.M;

@AllArgsConstructor
@Data
public class CommendLog
{
    private long t = M.ms();
    private String reason = "";
    private int points = 0;
}
