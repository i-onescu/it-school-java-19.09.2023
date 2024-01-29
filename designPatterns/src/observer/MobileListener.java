package designPatterns.src.observer;

public class MobileListener implements EventListener {
    private final String phoneNo;

    public MobileListener(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void update() {
        System.out.println("Sending SMS to " + phoneNo + "...");
    }
}
