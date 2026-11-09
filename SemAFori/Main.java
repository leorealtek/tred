package SemAFori;
public class Main {
    public static int nMacchine = 1;
    public static void main(String[] args) throws InterruptedException {
        GestoreSemaforo gS = new GestoreSemaforo(new Semaforo(false));
        gS.start();

        while(true) {
            Thread.sleep((int)(Math.random() * 10000));
            Auto a = new Auto(gS);
            System.out.println("Macchina " + nMacchine++ + " al semaforo");
            a.start();
        }
    }

}