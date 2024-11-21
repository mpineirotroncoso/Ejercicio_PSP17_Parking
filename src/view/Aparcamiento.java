package view;

import Controller.ParkingController;

import javax.swing.*;
import java.util.List;

public class Aparcamiento extends JPanel {
    public Aparcamiento(List<LabelPlaza> plazas) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Aparcamiento");
        add(label);
        for (int i = 0; i < 10; i++) {
            String matricula = ParkingController.getMatricula(i);
            System.out.println(plazas);
            add(plazas.get(i));
        }
    }
}
