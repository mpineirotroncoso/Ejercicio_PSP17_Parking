package view;

import model.Coche;

import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {


    public MainWindow(List<LabelPlaza> plazas, CartelLleno cartelLleno) {

        add(new Aparcamiento(plazas, cartelLleno));

        //add(cartelLleno);

        setTitle("Parking");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
