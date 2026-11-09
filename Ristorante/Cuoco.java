package Ristorante;

public class Cuoco implements Runnable {
    private String nome;
    private Ristorante ristorante;

    public Cuoco(String nome, Ristorante ristorante) {
        this.nome = nome;
        this.ristorante = ristorante;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            mettiPiatto();
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {}
            prendiPiatto();
        }
    }
    
    public synchronized void mettiPiatto() {
        Piatto piatto = new Piatto("Piatto normale", (int) (Math.random() * 10));
        for (int i = 0; i < ristorante.getPiatti().length; i++) {
            if (ristorante.getPiatti()[i] == null) {
                ristorante.getPiatti()[i] = piatto;
                piatto = null;
                break;
            }
        }
    }

    public synchronized void prendiPiatto() {
        for (int i = 0; i < ristorante.getPiatti().length; i++) {
            if (ristorante.getPiatti()[i] != null && ristorante.getPiatti()[i].isMangiato()) {
                ristorante.getPiatti()[i] = null;
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

}