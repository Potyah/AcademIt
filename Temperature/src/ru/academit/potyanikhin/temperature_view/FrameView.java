package ru.academit.potyanikhin.temperature_view;

import ru.academit.potyanikhin.temperature_model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FrameView implements View {
    private final Model model;
    final static String celsius = "Цельсий";
    final static String kelvin = "Кельвин";
    final static String fahrenheit = "Фрайнгейт";

    public FrameView(Model model) {
        this.model = model;
    }

    public void start() {
        JFrame frame = new JFrame("Temperature conversion");

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 2, 8, 8));

        JLabel inputDataLabel = new JLabel("Введите температуру:");
        container.add(inputDataLabel);

        JTextField inputData = new JTextField("", 5);
        container.add(inputData);

        JLabel inputDataTypeLabel = new JLabel("Переводим из:");
        container.add(inputDataTypeLabel);

        JLabel outputDataTypeLabel = new JLabel("Переводим в:");
        container.add(outputDataTypeLabel);

        JComboBox<String> inputDataTypeComboBox = new JComboBox<>(new String[]{celsius, kelvin, fahrenheit});
        inputDataTypeComboBox.setEditable(false);
        inputDataTypeComboBox.setSelectedItem(celsius);
        container.add(inputDataTypeComboBox);

        JComboBox<String> outputDataTypeComboBox = new JComboBox<>(new String[]{celsius, kelvin, fahrenheit});
        outputDataTypeComboBox.setEditable(false);
        outputDataTypeComboBox.setSelectedItem(kelvin);
        container.add(outputDataTypeComboBox);

        JLabel resultLabel = new JLabel();
        frame.add(resultLabel);

        JButton button = new JButton("Нажмите кнопку");
        frame.add(button);

        button.addActionListener(x -> {
            try {
                if (Objects.equals(inputDataTypeComboBox.getSelectedItem(), outputDataTypeComboBox.getSelectedItem())) {
                    JOptionPane.showMessageDialog(null, "Необходимо выбрать разные шкалы температур",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }

                double resultTemperature = Double.parseDouble(inputData.getText());
                resultTemperature = model.getConversion(resultTemperature, String.valueOf(inputDataTypeComboBox.getSelectedItem()),
                        String.valueOf(outputDataTypeComboBox.getSelectedItem()));

                resultLabel.setText("Результат: " + resultTemperature);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Проверьте корректность введеных данных",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}