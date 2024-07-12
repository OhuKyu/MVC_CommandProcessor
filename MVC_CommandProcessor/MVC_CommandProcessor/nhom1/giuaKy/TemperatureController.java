package buoi6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import buoi6.command_processor.CommandProcessor;
import buoi6.command_processor.setCelsiusCommand;
import buoi6.command_processor.setFahrenheitCommand;

public class TemperatureController {
    private TemperatureModel model;
    private TemperatureView view;
    private CommandProcessor commandProcessor = CommandProcessor.makeCommandProcessor();

    public TemperatureController(TemperatureModel model, TemperatureView view) {
        this.model = model;
        this.view = view;

        this.view.addC2FListener(new C2FListener());
        this.view.addF2CListener(new F2CListener());
        this.view.addExitListener(new ExitListener());
    }

    class C2FListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double celsius;
            try {
                celsius = Double.parseDouble(view.getCelsius());
                commandProcessor.execute(new setCelsiusCommand(celsius, model));
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Please enter a valid number");
            }
        }
    }

    class F2CListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double fahrenheit;
            try {
                fahrenheit = Double.parseDouble(view.getFahrenheit());
                commandProcessor.execute(new setFahrenheitCommand(fahrenheit, model));
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Please enter a valid number");
            }
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
