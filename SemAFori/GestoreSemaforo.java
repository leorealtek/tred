package SemAFori;
public class GestoreSemaforo extends Thread{
    private Semaforo semaforo;

    public GestoreSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            semaforo.cambiaColore();
            System.out.println((semaforo.isRosso()) ? "Semaforo Rosso" : "Semaforo Verde");
            try {Thread.sleep(3000);} catch (Exception e) {}
        }
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }
    
}