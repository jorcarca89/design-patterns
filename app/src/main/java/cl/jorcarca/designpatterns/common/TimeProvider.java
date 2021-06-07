package cl.jorcarca.designpatterns.common;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeProvider {
    private static Clock clock = Clock.systemDefaultZone();

    private TimeProvider() {
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(clock);
    }

    public static void fixClockAt(LocalDateTime localDateTime) {
        clock = Clock.fixed(localDateTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
    }
}
