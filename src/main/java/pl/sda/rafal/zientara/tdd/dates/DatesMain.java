package pl.sda.rafal.zientara.tdd.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatesMain {

    public static void main(String[] args) {

//        String input = "07-06-2017";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate output = LocalDate.parse(input, formatter);
//        System.out.println(output);
//
//        System.out.println(LocalDate.now().format(formatter));

        LocalDate currentDate = LocalDate.now();
        int fridaysCount = 0;
        while(fridaysCount < 5) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if(dayOfWeek != DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(1);
            } else {
                System.out.println(currentDate);
                currentDate = currentDate.plusWeeks(1);
                fridaysCount++;
            }
        }
    }
}
