package Pacchi;

import java.util.Random;

public class Operatore implements Runnable {
    private final Azienda azienda;
    private final Random random = new Random();

    public Operatore(Azienda azienda) {
        this.azienda = azienda;
    }

    @Override
    public void run() {
        try {
            while (azienda.getPacchiDisponibili() > 0) {
                try {
                    Thread.sleep(random.nextInt(10, 51));
                } catch (InterruptedException e) {
                    return;
                }

                Pacco pacco = azienda.tentaAssegnazione();
                if (pacco == null) return;
                System.out.println(Thread.currentThread().getName() + " ha assegnato " + pacco);
            }
        } finally {
            azienda.registraOperatoreTerminato();
        }
    }
}
