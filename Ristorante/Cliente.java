package Ristorante;

public class Cliente implements Runnable {
    private final String nome;
    private Piatto piatto;
    private final Ristorante ristorante;

    public Cliente(String nome, Ristorante ristorante) {
        this.nome = nome;
        this.ristorante = ristorante;
    }

    @Override
    public void run() {
        ristorante.registraCliente();
        for (int i = 0; i < 5; i++) {
            while (piatto == null) {
                prendiPiatto();
                if (piatto == null) try { Thread.sleep((long) (Math.random() * 200)); } catch (InterruptedException e) {}
            }
            try { Thread.sleep((long) (Math.random() * 200)); } catch (InterruptedException e) {}
            paga();
            rimettiPiatto();
            piatto = null;
        }
    }

    public void prendiPiatto() {
        piatto = ristorante.prendiPiatto();
    }

    public void rimettiPiatto() {
        ristorante.rimettiPiatto(piatto);
    }

    public void paga() {
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
