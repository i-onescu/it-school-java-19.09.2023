package designPatterns.src.observer;

public class EmailListener implements EventListener {
    private final String email;

    public EmailListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Sending email to " + email + "...");
    }
}
