package buoi6.command_processor;

import buoi6.TemperatureModel;

public abstract class Command {
    protected TemperatureModel temperatureModel;

    public Command(TemperatureModel temperatureModel) {
        this.temperatureModel = temperatureModel;
    }

    public abstract void execute();
}