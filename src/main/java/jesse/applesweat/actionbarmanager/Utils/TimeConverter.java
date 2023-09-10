package jesse.applesweat.actionbarmanager.Utils;

public class TimeConverter {
    public static long ticksToMillis(long ticks) {
        return ticks / 20 * 1000;
    }
}
