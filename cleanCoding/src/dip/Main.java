package cleanCoding.src.dip;

public class Main {

    public static void main(String[] args) {

        var service = new SendNotificationService(new SMSService());
        service.sendNotifications("test", "test");

    }

    boolean something(int x) {
        return x > 0 ? true : false;
    }
}
