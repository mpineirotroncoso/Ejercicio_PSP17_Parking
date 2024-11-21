package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Coche> cochesDentro = new ArrayList<Coche>();
    private int plazas = 10;

    public Parking() {
    }

    public List<Coche> getCochesDentro() {
        return cochesDentro;
    }

    public void setCochesDentro(List<Coche> cochesDentro) {
        this.cochesDentro = cochesDentro;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }



}
