package lewiscowles.core;


public final class MonotonicTimeSource implements TimeSourceInterface {
    public long getTime() {
        return getTimeInternal();
    }

    private static long lastTime;
    private synchronized static long getTimeInternal() {
        long now = System.currentTimeMillis();
        return (now > lastTime) ? lastTime=now : ++lastTime;
    }
}
