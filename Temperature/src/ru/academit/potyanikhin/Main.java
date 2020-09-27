package ru.academit.potyanikhin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.inter();



            }
        });
    }
}