package view;

import Controller.ParkingController;
import model.Coche;

import javax.swing.*;
import java.util.List;

public class Aparcamiento extends JPanel {
    public Aparcamiento() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Aparcamiento");
        add(label);
        for (int i = 0; i < 10; i++) {

            String matricula = ParkingController.getMatricula(i);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

            JLabel labelPlaza = new LabelPlaza(matricula);
            panel.add(labelPlaza);

            add(panel);
        }
    }
}
