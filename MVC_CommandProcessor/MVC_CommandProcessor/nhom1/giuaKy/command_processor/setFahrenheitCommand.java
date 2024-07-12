package buoi6.command_processor;

import buoi6.TemperatureModel;

public class setFahrenheitCommand extends Command {
    private double fahrenheit;

    public setFahrenheitCommand(double fahrenheit, TemperatureModel temperatureModel) {
        super(temperatureModel);
        this.fahrenheit = fahrenheit;
    }

    @Override
    public void execute() {
        temperatureModel.setFahrenheit(fahrenheit);
    }
}
