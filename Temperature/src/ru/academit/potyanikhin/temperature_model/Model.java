package ru.academit.potyanikhin.temperature_model;

public class Model {
    public double getConversion(double inputTemperature, String inputType, String outputType) {
        TemperatureConversion temperature;
        if (inputType.equals("Цельсий")) {
            temperature = new Celsius(inputTemperature);
        } else if (inputType.equals("Кельвин")) {
            temperature = new Kelvin(inputTemperature);
        } else {
            temperature = new Fahrenheit(inputTemperature);
        }

        if (outputType.equals("Цельсий")) {
            return temperature.getCelsiusConversion();
        }

        if (outputType.equals("Кельвин")) {
            return temperature.getKelvinConversion();
        }

        return temperature.getFahrenheitConversion();
    }
}
