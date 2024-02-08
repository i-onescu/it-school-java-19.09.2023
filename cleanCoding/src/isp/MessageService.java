package cleanCoding.src.isp;

public interface MessageService {

    void sendEmail(String to, String message);
    void sendSMS(String toNumber, String message);
    void sendPushNotifications(String to, String message);
}

class EmailService implements MessageService {
    @Override
    public void sendEmail(String to, String message) {

    }

    @Override
    public void sendSMS(String toNumber, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendPushNotifications(String to, String message) {
        throw new UnsupportedOperationException();
    }
}
