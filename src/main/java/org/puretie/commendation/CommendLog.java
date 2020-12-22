package org.puretie.commendation;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommendLog
{
    private long t;
    private String reason;
}
