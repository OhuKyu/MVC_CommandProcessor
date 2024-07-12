package buoi6.command_processor;

import buoi6.TemperatureModel;

public class setCelsiusCommand extends Command {
    private double celsius;

    public setCelsiusCommand(double celsius, TemperatureModel temperatureModel) {
        super(temperatureModel);
        this.celsius = celsius;
    }

    @Override
    public void execute() {
        temperatureModel.setCelsius(celsius);
    }
}