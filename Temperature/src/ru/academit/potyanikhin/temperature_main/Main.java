package ru.academit.potyanikhin.temperature_main;

import ru.academit.potyanikhin.temperature_model.Model;
import ru.academit.potyanikhin.temperature_view.FrameView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        FrameView view = new FrameView(model);

        SwingUtilities.invokeLater(view::start);
    }
}