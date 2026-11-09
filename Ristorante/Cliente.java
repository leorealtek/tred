package Ristorante;

public class Cliente implements Runnable {
    private String nome;
    private Piatto piatto;
    private Ristorante ristorante;

    public Cliente(String nome, Ristorante ristorante) {
        this.nome = nome;
        this.piatto = null;
        this.ristorante = ristorante;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            do {
                prendiPiatto();
                try {
                    Thread.sleep((long) (Math.random() * 200));
                } catch (InterruptedException e) {}
            } while (piatto != null);
            rimettiPiatto();
            paga();
        }
    }
    
    public synchronized void prendiPiatto() {
        for (int i = 0; i < ristorante.getPiatti().length; i++) {
            if (ristorante.getPiatti()[i] != null) {
                piatto = ristorante.getPiatti()[i];
                ristorante.getPiatti()[i] = null;
                break;
            }
        }
    }

    public synchronized void rimettiPiatto() {
        for (int i = 0; i < ristorante.getPiatti().length; i++) {
            if (ristorante.getPiatti()[i] == null) {
                piatto.mangia();
                ristorante.getPiatti()[i] = piatto;
                piatto = null;
                break;
            }
        }
    }

    public synchronized void paga() {
        ristorante.aggiungiSoldi(piatto.getPrezzo());
    }

    public String getNome() {
        return nome;
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

}