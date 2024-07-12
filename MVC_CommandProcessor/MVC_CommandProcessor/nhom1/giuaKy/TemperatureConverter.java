package buoi6;

public class TemperatureConverter {
    public static void main(String[] args) {
        TemperatureModel model = new TemperatureModel();
        TemperatureView view = new TemperatureView(model);
        new TemperatureController(model, view);
        view.setVisible(true);
    }
}