package ru.academit.potyanikhin.temperature_model;

public class Celsius implements TemperatureConversion {
    private final double temperature;

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getCelsiusConversion() {
        return temperature;
    }

    @Override
    public double getKelvinConversion() {
        return temperature + 273.15;
    }

    @Override
    public double getFahrenheitConversion() {
        return temperature * 1.8 + 32;
    }
}