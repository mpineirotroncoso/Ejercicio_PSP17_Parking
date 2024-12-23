package view;

import javax.swing.*;
import java.awt.*;

public class LabelPlaza extends JLabel {
    public LabelPlaza(String text) {
        super(text);
        setFont(getFont().deriveFont(20.0f));
    }

    public void setTexto(String text) {
        this.setText(text);
    }

    public void setColor(Color color) {
        this.setForeground(color);
    }

}
