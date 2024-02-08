package cleanCoding.src.dip;

public interface MessageService {
    void sendMessage(String to, String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String to, String message) {
        System.out.println("Sending Email...");
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String to, String message) {
        System.out.println("Sending SMS...");
    }
}
