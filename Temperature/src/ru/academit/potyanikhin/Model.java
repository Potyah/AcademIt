package ru.academit.potyanikhin;

public class Model {
    private double inputData;

    public double getEnteredTemperature() {
        return inputData;
    }

    public void setEnteredTemperature(double enteredTemperature) {
        this.inputData = enteredTemperature;
    }



    public double getCelsiusTemperature(double temperature, boolean isKelvin) {
        if (isKelvin) {
            return temperature * 1.8 + 32;

        }
        return temperature + 273.15;
    }




    public double getKelvinTemperature(double temperature, boolean isFahrenheit) {
        if (isFahrenheit) {
            return temperature * 1.8 + 32;

        }
        return temperature + 273.15;
    }





    public double getFahrenheitTemperature(double temperature, boolean isCelsius) {
        if (isCelsius) {
            return temperature * 1.8 + 32;

        }
        return temperature + 273.15;
    }


}
