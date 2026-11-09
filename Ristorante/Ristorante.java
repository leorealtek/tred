package Ristorante;

import java.util.concurrent.atomic.AtomicInteger;

public class Ristorante {
    private Piatto[] piatti;
    private Cuoco[] cuochi;
    private AtomicInteger piattiProdotti;
    private AtomicInteger clientiGiornalieri;
    private AtomicInteger ricavoGiornaliero;

    public Ristorante() {
        this.piatti = new Piatto[28];
        this.cuochi = new Cuoco[5];
        this.piattiProdotti = new AtomicInteger();
        this.clientiGiornalieri = new AtomicInteger();
        this.ricavoGiornaliero = new AtomicInteger();
    }

    public Piatto[] getPiatti() {
        return piatti;
    }

    public Cuoco[] getCuochi() {
        return cuochi;
    }

    public int getPiattiProdotti() {
        return piattiProdotti.get();
    }

    public int getClientiGiornalieri() {
        return clientiGiornalieri.get();
    }

    public int getRicavoGiornaliero() {
        return ricavoGiornaliero.get();
    }

    public void aggiungiSoldi(int quantita) {
        ricavoGiornaliero.addAndGet(quantita);
    }
    
}