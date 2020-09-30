package ru.academit.potyanikhin.temperature_model;

public class Fahrenheit implements TemperatureConversion {
    private final double temperature;

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getCelsiusConversion() {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double getKelvinConversion() {
        return (temperature - 32) * 5 / 9 + 273.15;
    }

    @Override
    public double getFahrenheitConversion() {
        return temperature;
    }
}
