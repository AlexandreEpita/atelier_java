package fr.epita.assistants.travel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.GregorianCalendar;

public class Travel {
    public static void travelTo(Country source, Country destination){

        if (source.travelTimes.get(destination.countryName) == null)
            return;

        LocalDateTime ldt = LocalDateTime.now(source.countryZone);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, source.countryZone);
        System.out.println("Boarding in " + source.countryName + ", local date and time is: " + zdt.format(DateTimeFormatter.RFC_1123_DATE_TIME));

        LocalDateTime ldt2 = LocalDateTime.now(destination.countryZone);
        ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, destination.countryZone).plusHours(source.travelTimes.get(destination.countryName));
        System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: " + zdt2.format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}