package Pacchi;

public class Pacco {
    private final String contenuto;
    private final String destinazione;

    public Pacco(String contenuto, String destinazione) {
        this.contenuto = contenuto;
        this.destinazione = destinazione;
    }

    @Override
    public String toString() {
        return "Pacco [Contenuto: " + contenuto + " Destinazione: " + destinazione + "]";
    }

}