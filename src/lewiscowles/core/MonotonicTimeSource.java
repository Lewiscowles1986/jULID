package lewiscowles.core;


public final class MonotonicTimeSource implements TimeSourceInterface {
    public long getTime() {
        /*
         * Note that this time-source returns a value very different,
         * but should be non-colliding with SystemTimeSource
         */
        return System.nanoTime();
    }
}
