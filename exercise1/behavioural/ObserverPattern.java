// Observer Interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Subject Interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class NotificationService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void newMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        Observer user1 = new User("User 1");
        Observer user2 = new User("User 2");

        service.registerObserver(user1);
        service.registerObserver(user2);

        service.newMessage("Design Patterns are awesome!");
    }
}
