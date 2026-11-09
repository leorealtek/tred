package Ristorante;

public class Cuoco implements Runnable {
    private final String nome;
    private final Ristorante ristorante;

    public Cuoco(String nome, Ristorante ristorante) {
        this.nome = nome;
        this.ristorante = ristorante;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Piatto piatto = new Piatto("Piatto normale", (int) (Math.random() * 10));
            while (!ristorante.mettiPiatto(piatto)) {
                try { Thread.sleep((long) (Math.random() * 200)); } catch (InterruptedException e) {}
            }
            try { Thread.sleep((long) (Math.random() * 200)); } catch (InterruptedException e) {}
            ristorante.rimuoviPiattiMangiati();
        }
        
    }

    public String getNome() {
        return nome;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }
}
