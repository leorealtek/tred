package Concerto;

import java.util.concurrent.atomic.AtomicInteger;

public class Mohemby {
    private final String cosa;
    private final int postiMassimi;
    private AtomicInteger postiAttuali;
    private AtomicInteger bigliettiRichiesti;

    public Mohemby(String cosa, int postiMassimi) {
        this.cosa = cosa;
        this.postiMassimi = postiMassimi;
        this.postiAttuali = new AtomicInteger(0);
        this.bigliettiRichiesti = new AtomicInteger(0);
    }
    
    public synchronized boolean prenota() {
        bigliettiRichiesti.incrementAndGet();
        if (postiAttuali.get() < postiMassimi) {
            postiAttuali.incrementAndGet();
            return true;
        }
        return false;
    }

    public String getCosa() {
        return cosa;
    }

    public int getPostiMassimi() {
        return postiMassimi;
    }

    public int getPostiAttuali() {
        return postiAttuali.get();
    }

    public int getBigliettiRichiesti() {
        return bigliettiRichiesti.get();
    }

}