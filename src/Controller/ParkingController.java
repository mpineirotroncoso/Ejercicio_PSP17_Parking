package Controller;

import model.Coche;
import model.Parking;
import view.Aparcamiento;
import view.LabelPlaza;
import view.MainWindow;

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
            } else {
                labelPlazas.get(i).setTexto("Vacio");
            }
        }
    }

    public static String getMatricula(int i) {

        if (cochesDentro.size() <= i) {
            return "Vacio";
        }

        return cochesDentro.get(i).getMatricula();
    }


    public static void iniciarParking() {
        ParkingController.actualizarInterfaz();
        MainWindow mainWindow = new MainWindow(labelPlazas);
        mainWindow.setVisible(true);

        for (int i = 0; i < 15; i++) {
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
