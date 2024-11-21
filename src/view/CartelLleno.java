package view;

import javax.swing.*;
import java.awt.*;

public class CartelLleno extends JPanel {
    JLabel label = new JLabel("Libre");
    public CartelLleno() {
        setBackground(Color.GREEN);
        label.setFont(label.getFont().deriveFont(35.0f));
        add(label);
    }

    public void setLleno() {
        setBackground(Color.RED);
        label.setText("Lleno");
    }

    public void setLibre() {
        setBackground(Color.GREEN);
        label.setText("Libre");
    }
}
