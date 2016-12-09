package lewiscowles.core;


import java.security.SecureRandom;
import static java.lang.Math.random;


public final class SystemTimeSource implements TimeSourceInterface {
    public long getTime() {
        return System.currentTimeMillis();
    }
}
