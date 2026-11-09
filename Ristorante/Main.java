package Ristorante;

public class Main {
    private static final int NUMERO_CLIENTI = 10;

    public static void main(String[] args) {
        Ristorante ristorante = new Ristorante();
        Cuoco[] cuochi = ristorante.getCuochi();
        Thread[] threadCuochi = new Thread[cuochi.length];
        Thread[] threadClienti = new Thread[NUMERO_CLIENTI];

        for (int i = 0; i < cuochi.length; i++) {
            cuochi[i] = new Cuoco("Cuoco " + (i + 1), ristorante);
            threadCuochi[i] = new Thread(cuochi[i]);
            threadCuochi[i].start();
        }

        for (int i = 0; i < threadClienti.length; i++) {
            Cliente cliente = new Cliente("Cliente " + (i + 1), ristorante);
            threadClienti[i] = new Thread(cliente);
            threadClienti[i].start();
        }

        while (ristorante.getClientiGiornalieri() < NUMERO_CLIENTI || ristorante.getPiattiProdotti() < cuochi.length * 10 || ristorante.getPiattiConsumati() < NUMERO_CLIENTI * 5) {
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }

        System.out.println("--- RIEPILOGO GIORNALIERO ---");
        System.out.println("Cuochi: " + cuochi.length);
        System.out.println("Clienti serviti: " + ristorante.getClientiGiornalieri());
        System.out.println("Piatti prodotti: " + ristorante.getPiattiProdotti());
        System.out.println("Piatti consumati: " + ristorante.getPiattiConsumati());
        System.out.println("Piatti disponibili: " + ristorante.getPiattiDisponibili());
        System.out.println("Ricavo giornaliero: " + ristorante.getRicavoGiornaliero());
    }
}
