package view;

import Controller.ParkingController;
import model.Coche;

import javax.swing.*;
import java.util.List;

public class Aparcamiento extends JPanel {
    public Aparcamiento(List<LabelPlaza> plazas, CartelLleno cartelLleno) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Aparcamiento");
        add(label);
        for (int i = 0; i < 10; i++) {
            System.out.println(plazas);
            String matricula = ParkingController.getMatriculaFromPlaza(i);
            System.out.println(matricula);

            add(plazas.get(i));
        }
        add(cartelLleno);
    }
}
