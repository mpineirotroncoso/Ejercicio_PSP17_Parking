package Controller;

import model.Coche;

import java.awt.*;

public class HiloCoche extends Thread {
    int random;
    public HiloCoche() {
    }

    public void run() {
        while (true) {
            Coche coche = new Coche(Color.red, ParkingController.generarMatricula());
            System.out.println("El coche con matricula " + coche.getMatricula() + " esta acercandose al parking");

            /**
             * Entrar coche
             */
            random = (int) (Math.random() * 20000);
            try {
                sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Coche " + coche.getMatricula() + " entrando al parking");
            if (!ParkingController.entrarCoche(coche)) {
                System.out.println("Parking lleno, el coche " + coche.getMatricula() + " no va a entrar en el parking");
                HiloCoche hiloCoche = new HiloCoche(); // iniciar otro hilo
                hiloCoche.start();
                return;
            }


            random = (int) (Math.random() * 20000);
            try {
                sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            /**
             * Salir coche
             */
            System.out.println("Coche " + coche.getMatricula() + " saliendo del parking");
            ParkingController.salirCoche(coche.getMatricula());

            int random = (int) (Math.random() * 20000);
            try {
                sleep(random);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
