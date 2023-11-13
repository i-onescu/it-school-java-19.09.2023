import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws ParseException {

        Student student = new Student("John", 21);
        Student student2 = student;

        Student student3 = new Student("John", 21);

        if (student.equals(student3)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        // LocalDate stores only the date
        // this class is immutable

        // a way of instantiating a LocalDate class by providing
        // year, month and day of month
        LocalDate localDate = LocalDate.of(2015, 07, 17);
        // This will retrieve the current date
        LocalDate now = LocalDate.now();

        // This is how you can add weeks to a date,
        // the same can happen for days, months and years.
        // Note that a copy is returned as LocalDate is immutable.
        LocalDate localDate1 = localDate.plusWeeks(2);
        System.out.println(localDate1);

        System.out.println(localDate);
        System.out.println(now);

        // the same as described for LocalDate
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusHours(5);

        System.out.println(localDateTime1);

        // extract only the date component from a LocalDateTime instance
        LocalDate localDate2 = localDateTime.toLocalDate();
        // extract only the time component from a LocalDateTime instance
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println(localTime);

        // checks if a LocalDateTime is before another one
        if (localDateTime.isBefore(localDateTime1)) {
            System.out.println("before");
        } else {
            System.out.println("after");
        }

        // You can convert a String value to a LocalDateTime using DateTimeFormatter
        String myDateTimeString = "September-25-2023 18:58";
        // You must provide a corresponding pattern
        // M - month
        // m - minutes
        // d - days
        // y - year
        // H - hours
        // s - seconds
        // S - milliseconds/nanoseconds
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM-dd-yyyy HH:mm");

        // parse() method will do the magic
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse(myDateTimeString, dateTimeFormatter);
        LocalDateTime nowLocal = LocalDateTime.now();

        System.out.println(parsedLocalDateTime.format(dateTimeFormatter));
        System.out.println(nowLocal);

        // on the other hand, the format() method will do the job to convert
        // the localDateTime into a pattern, so you can visualize the date and time how you like.
        System.out.println(nowLocal.format(dateTimeFormatter));

        // if you call new Date() on java.util.Date it will get the current date time.
        java.util.Date oldDate = new java.util.Date();

        // java.sql.Date is generally used for SQL DATE columns in Databases
        // it needs the number of milliseconds passed since 01 Jan 1970.
        //Date date = new Date();
        // java.sql.Date is a subtype of java.util.Date
        // and it stores only the date component.
        java.sql.Date date = new java.sql.Date(1199378073348L);

        System.out.println(date);
        //System.out.println(date);

        // you can also format a date using SimpleDateFormat,
        // which is in fact the equivalent of DateTimeFormatter from LocalDate[Time]
        String formatDate = "MMM-yyyy-dd H:m";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDate);
        System.out.println(simpleDateFormat.format(date));

        // if you want to retrieve only the time component, you have to extract it
        // using a pattern
        String timeFormat = "HH:mm:ss";
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat(timeFormat);
        System.out.println(simpleDateFormatTime.format(date));

        // the same for the date component
        String dateFormat = "MM-yy-dd";
        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat(dateFormat);
        System.out.println(simpleDateFormatDate.format(date));

        // if you want to add days/months/years to a java.util.Date
        // you need a 'Calendar' instance
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.YEAR, 5);
        java.util.Date time = instance.getTime();

        System.out.println(simpleDateFormatDate.format(time));

        // if two classes have the name you must use the FQN (fully qualified name)
        // it consists out of the package name and the class name
        java.sql.Date sqlDate = new java.sql.Date(1199378073348L);
        java.util.Date dateUtil = new java.util.Date();

        // java.sql.Timestamp stores both the date and time, the same used for SQL TIMESTAMP type.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp oldTimestamp = Timestamp.valueOf(LocalDateTime.of(2015, 01, 01, 1, 1));

        // prints the years between 2 timestamps
        System.out.println((timestamp.getTime() - oldTimestamp.getTime()) / 1000 / 60 / 60 / 24 / 30 / 12);

        java.util.Date currentDate = new java.util.Date();
        Timestamp timestamp1 = new Timestamp(currentDate.getTime());

        System.out.println(timestamp1);

        // random is used to generate pseudorandom numbers
        // it can also support a seed which will take care of generating the same numbers always
        Random random = new Random();
        int[] ints = new int[10];

        for (int i = 0; i < 10; i++) {
            ints[i] = random.nextInt(100);
            System.out.println(ints[i]);
        }

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student stud) {
            return this.name.equals(stud.name)
                    && this.age == stud.age;
        }
        return false;
    }
}
