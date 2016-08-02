package lewiscowles.core;


import static java.lang.Math.floor;
import static java.lang.Math.random;


public final class ulid {
    public String[] ENCODING = { "0","1","2","3","4","5","6","7","8","9",
                                 "A","B","C","D","E","F","G","H","J","K",
                                 "M","N","P","Q","R","S","T","V","W","X",
                                 "Y","Z"};
    public static long ENCODING_LENGTH = 32;

    public String get()
    {
        return encodeTime( getTime(), 10) + encodeRandom(16);
    }

    protected String encodeTime(long time, long length)
    {
        String out = "";
        while(length > 0) {
            int mod = (int)(time % ENCODING_LENGTH);

            out = ENCODING[mod] + out;
            time = (time - mod) / ENCODING_LENGTH;
            length--;
        }
        return out;
    }

    protected String encodeRandom(long length)
    {
        String out = "";
        while(length > 0) {
            int rand = (int)(floor(ENCODING_LENGTH * getRand()));
            out = ENCODING[rand] + out;
            length--;
        }
        return out;
    }

    protected double getRand()
    {
        return random();
    }

    protected long getTime()
    {
        return System.currentTimeMillis();
    }
}
