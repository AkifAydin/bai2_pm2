package modelgenerator;

import model.Amount;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomUtil {

    private static final Random rand = new Random(78172971);
    public static Random getRandom(){return rand;}

    public static LocalDate randomInRange(LocalDate min, LocalDate max) {

        // beide Datumsangaben haben gleichen Tag und Monat
        Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(min.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        int yearDiff = max.getYear() - min.getYear();
        int monthDiff = 12;
        int dayOfMonthDiff = 31;

        cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+ rand.nextInt(yearDiff));
        cal.set(Calendar.MONTH, rand.nextInt(monthDiff) + 1);
        cal.set(Calendar.DAY_OF_MONTH, rand.nextInt(dayOfMonthDiff) + 1);

        return Instant.ofEpochMilli(cal.getTime().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Amount randomInRange(Amount min, Amount max) {
        return min.add(RandomUtil.getRandom().nextInt((max.sub(min).getEuro())));
    }
}
