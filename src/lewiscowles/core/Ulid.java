package lewiscowles.core;


import static java.lang.Math.floor;


public final class Ulid {
    public final String[] ENCODING = {  "0","1","2","3","4","5","6","7","8","9",
                                        "A","B","C","D","E","F","G","H","J","K",
                                        "M","N","P","Q","R","S","T","V","W","X",
                                        "Y","Z"};
    public final long ENCODING_LENGTH = 32;

    protected final TimeSourceInterface time_source;
    protected final RandomGeneratorInterface rand_gen;

    public Ulid(TimeSourceInterface ts, RandomGeneratorInterface rg) {
        time_source = ts;
        rand_gen = rg;
    }

    public String get()
    {
        return encodeTime( time_source.getTime(), 10) + encodeRandom(16);
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
            int rand = (int)(floor(ENCODING_LENGTH * rand_gen.generate()));
            out = ENCODING[rand] + out;
            length--;
        }
        return out;
    }

}
