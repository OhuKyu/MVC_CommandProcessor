package buoi6;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.*;
import buoi6.observer.Subscriber;

public class TemperatureView extends JFrame implements Subscriber {
    private JTextField celsiusTextField = new JTextField(10);
    private JTextField fahrenheitTextField = new JTextField(10);
    private JMenuItem c2fMenuItem = new JMenuItem("Convert Celsius to Fahrenheit");
    private JMenuItem f2cMenuItem = new JMenuItem("Convert Fahrenheit to Celsius");
    private JMenuItem exitMenuItem = new JMenuItem("Exit");
    private TemperatureModel model;

    public TemperatureView(TemperatureModel model) {
        this.model = model;
        model.subscribe(this);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Celsius"));
        panel.add(celsiusTextField);
        panel.add(new JLabel("Fahrenheit"));
        panel.add(fahrenheitTextField);

        JMenuBar menuBar = new JMenuBar();
        JMenu convertMenu = new JMenu("Convert");
        convertMenu.add(c2fMenuItem);
        convertMenu.add(f2cMenuItem);
        menuBar.add(convertMenu);

        JMenu exitMenu = new JMenu("File");
        exitMenu.add(exitMenuItem);
        menuBar.add(exitMenu);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Temperature Converter");
        this.setSize(400, 150);
        this.add(panel);

        // Add Enter key listeners
        celsiusTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    c2fMenuItem.doClick();
                }
            }
        });

        fahrenheitTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    f2cMenuItem.doClick();
                }
            }
        });
    }

    public String getCelsius() {
        return celsiusTextField.getText();
    }

    public String getFahrenheit() {
        return fahrenheitTextField.getText();
    }

    public void setCelsius(String celsius) {
        celsiusTextField.setText(celsius);
    }

    public void setFahrenheit(String fahrenheit) {
        fahrenheitTextField.setText(fahrenheit);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public void update() {
        setCelsius(String.valueOf(model.getCelsius()));
        setFahrenheit(String.valueOf(model.getFahrenheit()));
    }

    public void addC2FListener(ActionListener listener) {
        c2fMenuItem.addActionListener(listener);
    }

    public void addF2CListener(ActionListener listener) {
        f2cMenuItem.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        exitMenuItem.addActionListener(listener);
    }
}