package wwy.date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * 
 * @author wwy
 * @date 2015年6月14日上午11:25:02
 */
public class DateTest {
    
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime2 = LocalDateTime.parse("2015-04-22 23:45:56", dateTimeFormatter);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        System.out.println(dateTime2);
        System.exit(1);
        Duration duration = Duration
                .between(Instant.ofEpochMilli(System.currentTimeMillis() - 12323123), Instant.now());
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
        System.exit(1);
        LocalDate date = LocalDate.now();
        LocalDateTime d6 = LocalDateTime.now();
        System.out.println(d6.getYear());
        System.out.println(d6.getMonth().getValue());
        System.out.println(d6.getDayOfYear());
        System.out.println(d6.getDayOfMonth());
        System.out.println(d6.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINA));
        System.out.println(d6.getHour());
        System.out.println(d6.getMinute());
        System.out.println(d6.getSecond());
        System.out.println(d6.getNano());
        System.out.println(date);
        date = date.of(2015, 5, 4);
        System.out.println(date);
        System.exit(1);
        Clock clock = Clock.systemUTC();
        Clock c4 = Clock.fixed(Instant.now(), ZoneId.of("Asia/Shanghai"));// 固定上海时区时钟
        Clock c5 = Clock.offset(clock, Duration.ofSeconds(-2));
        System.out.println(clock.millis());
        System.out.println(c4.millis());
        System.out.println(c5.millis());
        System.out.println(clock.millis());
        System.out.println(Instant.now().getNano());
    }
}
