package cleanCoding.src.dip;

public class SendNotificationService {

    private final MessageService messageService;

    public SendNotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotifications(String to, String message) {
        // determined at runtime
        messageService.sendMessage(to, message);
    }
}
