package Ristorante;

import java.util.concurrent.atomic.AtomicInteger;

public class Ristorante {
    private final Piatto[] piatti = new Piatto[28];
    private final Piatto[] piattiInServizio = new Piatto[28];
    private final Cuoco[] cuochi = new Cuoco[5];
    private final AtomicInteger piattiProdotti = new AtomicInteger();
    private final AtomicInteger piattiConsumati = new AtomicInteger();
    private final AtomicInteger clientiGiornalieri = new AtomicInteger();
    private final AtomicInteger ricavoGiornaliero = new AtomicInteger();

    public synchronized boolean mettiPiatto(Piatto piatto) {
        rimuoviPiattiMangiati();
        for (int i = 0; i < piatti.length; i++) {
            if (piatti[i] == null && piattiInServizio[i] == null) {
                piatti[i] = piatto;
                piattiProdotti.getAndIncrement();
                return true;
            }
        }
        return false;
    }

    public synchronized Piatto prendiPiatto() {
        for (int i = 0; i < piatti.length; i++) {
            if (piatti[i] != null && !piatti[i].isMangiato()) {
                Piatto piatto = piatti[i];
                piatti[i] = null;
                piattiInServizio[i] = piatto;
                return piatto;
            }
        }
        return null;
    }

    public synchronized void rimettiPiatto(Piatto piatto) {
        for (int i = 0; i < piattiInServizio.length; i++) {
            if (piattiInServizio[i] == piatto) {
                piatto.mangia();
                piatti[i] = piatto;
                piattiInServizio[i] = null;
                piattiConsumati.getAndIncrement();
                return;
            }
        }
    }

    public synchronized void rimuoviPiattiMangiati() {
        for (int i = 0; i < piatti.length; i++) {
            if (piatti[i] != null && piatti[i].isMangiato()) {
                piatti[i] = null;
            }
        }
    }

    public synchronized int getPiattiDisponibili() {
        int disponibili = 0;
        for (Piatto piatto : piatti) {
            if (piatto != null && !piatto.isMangiato()) disponibili++;
        }
        return disponibili;
    }

    public Cuoco[] getCuochi() {
        return cuochi;
    }

    public int getPiattiProdotti() {
        return piattiProdotti.get();
    }

    public int getPiattiConsumati() {
        return piattiConsumati.get();
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

    public void registraCliente() {
        clientiGiornalieri.getAndIncrement();
    }

}
