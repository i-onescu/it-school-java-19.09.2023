package designPatterns.src.observer;

public class Main {

    public static void main(String[] args) {
        EventListener user1 = new EmailListener("bogdan@itschool.ro");
        EventListener user2 = new MobileListener("0712345678");

        NotificationService notificationService = new NotificationService();

        notificationService.subscribe(user1);
        notificationService.notifyUsers();

        System.out.println("----");

        notificationService.subscribe(user2);
        notificationService.notifyUsers();

        System.out.println("----");

        notificationService.unsubscribe(user1);
        notificationService.notifyUsers();

        System.out.println("----");
    }
}
