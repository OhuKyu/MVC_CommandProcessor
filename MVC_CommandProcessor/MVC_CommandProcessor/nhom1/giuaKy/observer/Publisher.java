package buoi6.observer;

import java.util.LinkedList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new LinkedList<>();

    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
