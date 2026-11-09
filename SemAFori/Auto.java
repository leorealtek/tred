package SemAFori;
public class Auto extends Thread {
    private GestoreSemaforo gestore;
    private static int numero = 1;

    public Auto(GestoreSemaforo gestore) {
        this.gestore = gestore;
    }

    @Override
    public void run() {
        while (gestore.getSemaforo().isRosso()) {
            try {Thread.sleep(1000);} catch (Exception e) {}
        }
        System.out.println("Macchina " + numero++ + " passata");
    }
    
}
