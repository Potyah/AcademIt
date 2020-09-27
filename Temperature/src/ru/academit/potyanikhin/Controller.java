package ru.academit.potyanikhin;

public class Controller {
    private Model model;

    public Controller(Model model) {
      this.model = model;
    }

    public boolean checkData(String textEnteredTemperature) {
   //     String regex = "[0-9,.]";

     //   return textEnteredTemperature.matches(regex);

        return textEnteredTemperature.chars().allMatch(Character::isDigit);
    }
}
