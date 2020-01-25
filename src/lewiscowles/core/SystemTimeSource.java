package lewiscowles.core;


public final class SystemTimeSource implements TimeSourceInterface {
    public long getTime() {
        return System.currentTimeMillis();
    }
}
