package model;

import java.awt.*;

public class Coche {
    private Color color;
    private String matricula;
    private int id;

    public Coche(Color color, String matricula) {
        this.color = color;
        this.matricula = matricula;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
