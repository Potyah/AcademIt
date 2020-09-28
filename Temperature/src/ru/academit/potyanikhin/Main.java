package ru.academit.potyanikhin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        FrameView view = new FrameView();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.start();



            }
        });
    }
}