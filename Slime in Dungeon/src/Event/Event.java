package Event;

import Character.*;

public class Event
{
    public static boolean checkHit(Slime slime,Ghost_Wave wave,int SlimeSize,int waveHeight)
    {
        if(slime.x+SlimeSize>wave.x&&slime.x<wave.x)
        {
            if (slime.y + SlimeSize > wave.y - waveHeight)
            {
                if (slime.y + SlimeSize < wave.y + waveHeight)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHit1(Slime slime,Ghost_Wave1 wave,int SlimeSize,int waveHeight)
    {
        if(slime.x+SlimeSize>wave.x&&slime.x<wave.x)
        {
            if (slime.y + SlimeSize > wave.y - waveHeight)
            {
                if (slime.y + SlimeSize < wave.y + waveHeight)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHit2(Slime slime,Ghost_Wave2 wave,int SlimeSize,int waveHeight)
    {
        if(slime.x+SlimeSize>wave.x&&slime.x<wave.x)
        {
            if (slime.y + SlimeSize > wave.y - waveHeight)
            {
                if (slime.y + SlimeSize < wave.y + waveHeight)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
