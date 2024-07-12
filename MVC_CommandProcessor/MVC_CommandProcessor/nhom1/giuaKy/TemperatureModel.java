package buoi6;

import buoi6.observer.Publisher;

public class TemperatureModel extends Publisher {
    private double celsius;
    private double fahrenheit;

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        this.fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        changeState();
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
        this.celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        changeState();
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    private void changeState() {
        notifySubscribers();
    }
}