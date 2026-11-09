package Pacchi;

public class Main {
    private static final String[] CONTENUTI = {"Vuoto", "Pieno", "Mezzo e mezzo"};
    private static final int NUMERO_PACCHI = 120;
    private static final int NUMERO_OPERATORI = 50;

    public static void main(String[] args) {
        Pacco[] pacchi = new Pacco[NUMERO_PACCHI];
        for (int i = 0; i < pacchi.length; i++) {
            pacchi[i] = new Pacco(CONTENUTI[i % CONTENUTI.length], "Mare");
        }

        Azienda azienda = new Azienda(pacchi);
        Thread[] threads = new Thread[NUMERO_OPERATORI];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Operatore(azienda), "Operatore - " + (i + 1));
            threads[i].start();
        }

        while (azienda.getOperatoriTerminati() < threads.length) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }

        System.out.println("\n--- RIEPILOGO SIMULAZIONE ---");
        System.out.println("Pacchi iniziali: " + azienda.getPacchiIniziali());
        System.out.println("Pacchi assegnati: " + azienda.getAssegnazioniRiuscite());
        System.out.println("Pacchi rimanenti: " + azienda.getPacchiDisponibili());
        System.out.println("Tentativi effettuati: " + azienda.getTentativi());
        System.out.println("Assegnazioni riuscite: " + azienda.getAssegnazioniRiuscite());
        System.out.println("Assegnazioni fallite: " + azienda.getAssegnazioniFallite());
        System.out.println("Verifica tentativi: " + (azienda.getTentativi() == azienda.getAssegnazioniRiuscite() + azienda.getAssegnazioniFallite()));

    }
}
