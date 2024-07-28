import java.util.ArrayList;
import java.util.List;

// Observable class
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Observer interface
interface Observer {
    void update(int temperature);
}

// Concrete observers
class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone Display: Current Temperature: " + temperature + "°C");
    }
}

class WindowDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Window Display: Current Temperature: " + temperature + "°C");
    }
}

// Usage
public class Test2 {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        WindowDisplay windowDisplay = new WindowDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(windowDisplay);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);
    }
}