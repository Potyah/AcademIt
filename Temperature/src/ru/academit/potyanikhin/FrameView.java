package ru.academit.potyanikhin;

import javax.swing.*;
import java.awt.*;

public class FrameView implements View {
 //   private final Controller controller;




    final static String CELSIUS = "Цельсий";
    final static String KELVIN = "Кельвин";
    final static String FAHRENHEIT = "Фрайнгейт";



    public void start() {
        JFrame frame = new JFrame("Temperature conversion");

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 2, 8, 8));

        JLabel label = new JLabel("Введите температуру: ");
        container.add(label);

        JTextField inputData = new JTextField("", 5);
        container.add(inputData);

        JLabel inputDataTypeLabel = new JLabel("Переводим из ");
        container.add(inputDataTypeLabel);

        JLabel outputDataTypeLabel = new JLabel("Переводим в");
        container.add(outputDataTypeLabel);

        JComboBox<String> box1 = new JComboBox<>(new String[]{CELSIUS, KELVIN, FAHRENHEIT});
        box1.setEditable(true);
        container.add(box1);

        JComboBox<String> box2 = new JComboBox<>(new String[]{CELSIUS, KELVIN, FAHRENHEIT});
        box2.setSize(50, 50);
        box1.setEditable(false);
        container.add(box2);

        JLabel resultData = new JLabel();
        frame.add(resultData);

        JButton button = new JButton("Нажмите кнопку");
        frame.add(button);
        button.addActionListener(x -> {
            try {
                double resultTemperature = Double.parseDouble(inputData.getText());

                resultData.setText("Все работает. Вы ввели " + resultTemperature);



            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Проверьте корректность введеных данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }


    public void showResult() {


    }

}