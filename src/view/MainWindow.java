package view;

import model.Coche;

import javax.swing.*;
import java.util.List;

public class MainWindow extends JFrame {


    public MainWindow(List<LabelPlaza> plazas) {

        add(new Aparcamiento(plazas));

        setTitle("Parking");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
