import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String day = scanner.nextLine();

        System.out.println(Weekday.getWeekdayType(day));
    }
}

enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static String getWeekdayType(String weekday) {
        Weekday weekdayEnum = Weekday.valueOf(weekday);

        return switch (weekdayEnum) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }
}
