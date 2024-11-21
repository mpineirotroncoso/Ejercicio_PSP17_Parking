package Controller;

import model.Coche;
import model.Parking;
import view.Aparcamiento;
import view.CartelLleno;
import view.LabelPlaza;
import view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingController {
    static Parking parking = new Parking();
    static int plazasTotales = parking.getPlazas();
    static List<Coche> cochesDentro = parking.getCochesDentro();
    static List<LabelPlaza> labelPlazas = new ArrayList<>(10);
    static {
        for (int i = 0; i < 10; i++) {
            labelPlazas.add(new LabelPlaza("Vacio"));
        }
    }
    static CartelLleno cartelLleno = new CartelLleno();

    public static boolean entrarCoche(Coche coche) {
        //Coche coche = new Coche(Color.red, "1234ABC");

        if (cochesDentro.size() >= plazasTotales) {
            // System.out.println("Parking lleno");
            return false;
        }
        cochesDentro.add(coche);
        actualizarInterfaz();
        return true;
    }

    public static boolean salirCoche(String matricula) {

        if (!cochesDentro.isEmpty()) {
            for (int i = 0; i < cochesDentro.size(); i++) {
                if (cochesDentro.get(i).getMatricula() == matricula ) {
                    cochesDentro.remove(i);
                    //System.out.println("Coche sale del parking");
                    actualizarInterfaz();
                    return true;
                }
            }
        }
        System.out.println("Coche no encontrado");
        return false;
    }

    private static void actualizarInterfaz() {
        for (int i = 0; i < labelPlazas.size(); i++) {
            if (i < cochesDentro.size()) {
                labelPlazas.get(i).setTexto(cochesDentro.get(i).getMatricula());
                labelPlazas.get(i).setColor(cochesDentro.get(i).getColor());
            } else {
                labelPlazas.get(i).setTexto("Vacio");
                labelPlazas.get(i).setColor(Color.BLACK);
            }
        }
        if (ParkingController.parkingLleno()) {
            cartelLleno.setLleno();
        } else {
            cartelLleno.setLibre();
        }
    }

    public static Color generarColorRandom() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public static String getMatricula(int i) {

        if (cochesDentro.size() <= i) {
            return "Vacio";
        }

        return cochesDentro.get(i).getMatricula();
    }

    public static boolean parkingLleno() {
        return cochesDentro.size() >= plazasTotales;
    }


    public static void iniciarParking() {
        ParkingController.actualizarInterfaz();
        MainWindow mainWindow = new MainWindow(labelPlazas, cartelLleno);
        mainWindow.setVisible(true);

        for (int i = 0; i < 25; i++) {
            HiloCoche hiloCoche = new HiloCoche();
            hiloCoche.start();
        }
    }

    public static String generarMatricula() {
        StringBuilder matricula = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            matricula.append((int) (Math.random() * 10));
        }
        for (int i = 0; i < 3; i++) {
            matricula.append((char) (Math.random() * 26 + 'A'));
        }
        return matricula.toString();
    }

    public static Coche getCocheFromMatricula(String matricula) {
        for (Coche coche : cochesDentro) {
            if (coche.getMatricula().equals(matricula)) {
                System.out.println(coche);
                return coche;
            }
        }
        return null;
    }

    public static String getMatriculaFromPlaza(int i) {
        return labelPlazas.get(i).getText();
    }
}
