package ru.academit.potyanikhin;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    final static String CELSIUS = "Цельсий";
    final static String KELVIN = "Кельвин";
    final static String FAHRENHEIT = "Фрайнгейт";

    private JLabel label = new JLabel("Введите температуру: ");
    private JTextField inputData = new JTextField("", 5);
    private JLabel dataType = new JLabel("Переводим из ");
    private JLabel outputType = new JLabel("Переводим в");
    private JLabel outputData = new JLabel();
    private JButton button = new JButton("Нажмите кнопку");

  //  Controller controller = new Controller();

 //   public View(Controller controller) {
//        this.controller = controller;
//    }

    public void inter() {
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(4, 2, 8, 8));

        container.add(label);
        container.add(inputData);

        container.add(dataType);
        container.add(outputType);

        JComboBox<String> box1 = new JComboBox<>(
                new String[]{CELSIUS, KELVIN, FAHRENHEIT});
        box1.setEditable(false);
        container.add(box1);

        JComboBox<String> box2 = new JComboBox<>(
                new String[]{CELSIUS, KELVIN, FAHRENHEIT});
        box2.setSize(50, 50);
        box1.setEditable(false);
        container.add(box2);

        add(outputData);

        add(button);
        button.addActionListener(x -> {
            double enteredTemperature;
            String textEnteredTemperature = this.inputData.getText();

            enteredTemperature = Double.parseDouble(textEnteredTemperature);

   //         boolean isNumbers = controller.checkData(textEnteredTemperature);

            outputData.setText("Все работает. Вы ввели " + enteredTemperature);
        });

        setVisible(true);
    }
}