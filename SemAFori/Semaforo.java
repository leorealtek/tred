package SemAFori;
public class Semaforo {
    private boolean rosso;

    public Semaforo(boolean rosso) {
        this.rosso = rosso;
    }

    public boolean isRosso() {
        return rosso;
    }

    public void cambiaColore() {
        rosso = !rosso;
    }
    
}