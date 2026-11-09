package Pacchi;

import java.util.concurrent.atomic.AtomicInteger;

public class Azienda {
    private final Pacco[] pacchi;
    private int prossimaAssegnazione;
    private int tentativi;
    private int assegnazioniRiuscite;
    private int assegnazioniFallite;
    private final AtomicInteger operatoriTerminati = new AtomicInteger(0);

    public Azienda(Pacco[] pacchi) {
        if (pacchi == null) throw new IllegalArgumentException("L'elenco dei pacchi non puo essere null.");
        this.pacchi = pacchi.clone();
    }

    public synchronized Pacco tentaAssegnazione() {
        tentativi++;
        if (prossimaAssegnazione >= pacchi.length) {
            assegnazioniFallite++;
            return null;
        }

        Pacco pacco = pacchi[prossimaAssegnazione];
        pacchi[prossimaAssegnazione] = null;
        prossimaAssegnazione++;
        assegnazioniRiuscite++;
        return pacco;
    }

    public synchronized int getPacchiDisponibili() {
        return pacchi.length - prossimaAssegnazione;
    }

    public synchronized int getTentativi() {
        return tentativi;
    }

    public synchronized int getAssegnazioniRiuscite() {
        return assegnazioniRiuscite;
    }

    public synchronized int getAssegnazioniFallite() {
        return assegnazioniFallite;
    }

    public int getPacchiIniziali() {
        return pacchi.length;
    }

    public void registraOperatoreTerminato() {
        operatoriTerminati.getAndIncrement();
    }

    public int getOperatoriTerminati() {
        return operatoriTerminati.get();
    }
}
