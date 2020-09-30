package ru.academit.potyanikhin.temperature_model;

public class Kelvin implements TemperatureConversion {
    private final double temperature;

    public Kelvin(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getCelsiusConversion() {
        return temperature - 273.15;
    }

    @Override
    public double getKelvinConversion() {
        return temperature;
    }

    @Override
    public double getFahrenheitConversion() {
        return (temperature - 273.15) * 9 / 5 + 32;
    }
}