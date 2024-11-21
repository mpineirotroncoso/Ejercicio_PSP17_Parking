package Controller;

import model.Coche;
import model.Parking;
import view.MainWindow;

import java.awt.*;
import java.util.List;

public class ParkingController {
    static Parking parking = new Parking();
    static int plazasTotales = parking.getPlazas();
    static List<Coche> cochesDentro = parking.getCochesDentro();

    public static boolean entrarCoche(Coche coche) {
        //Coche coche = new Coche(Color.red, "1234ABC");

        if (cochesDentro.size() >= plazasTotales) {
            // System.out.println("Parking lleno");
            return false;
        }
        cochesDentro.add(coche);
        return true;
    }

    public static boolean salirCoche(String matricula) {

        if (!cochesDentro.isEmpty()) {
            for (int i = 0; i < cochesDentro.size(); i++) {
                if (cochesDentro.get(i).getMatricula() == matricula ) {
                    cochesDentro.remove(i);
                    //System.out.println("Coche sale del parking");
                    return true;
                }
            }
        }
        System.out.println("Coche no encontrado");
        return false;
    }

    public static boolean parkingLleno() {
        System.out.println(cochesDentro);

        System.out.println("Hay " + cochesDentro.size() + " coches");
        if (cochesDentro.size() >= plazasTotales) {
            return true;
        } else {
            return false;
        }
    }

    public static String getMatricula(int i) {

        if (cochesDentro.size() <= i) {
            return "Vacio";
        }

        return cochesDentro.get(i).getMatricula();
    }

    public static int getIntCochesDentro() {
        return cochesDentro.size();
    }

    public static void iniciarParking() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);

        for (int i = 0; i < 5; i++) {
            HiloCoche hiloCoche = new HiloCoche();
            hiloCoche.start();
        }
    }

    public static String generarMatricula() {
        String matricula = "";
        for (int i = 0; i < 4; i++) {
            matricula += (char) (Math.random() * 26 + 'A');
        }
        matricula += "-";
        for (int i = 0; i < 4; i++) {
            matricula += (char) (Math.random() * 26 + 'A');
        }
        return matricula;
    }
}
