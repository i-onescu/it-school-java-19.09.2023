package designPatterns.src.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<EventListener> subscribers;

    public NotificationService() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(EventListener eventListener) {
        subscribers.add(eventListener);
    }

    public void unsubscribe(EventListener eventListener) {
        subscribers.remove(eventListener);
    }

    public void notifyUsers() {
        subscribers.forEach(EventListener::update);
    }
}
