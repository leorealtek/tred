package Concerto;

public class Main {
    public static final String[] NOMI = {"Tappete", "Tippete", "Toppete", "4 aura", "mAICOL", "Giecson", "Cosk", "Argaz", "Ge", "Gej"};
    public static final int PERSONE = 10;
    public static void main(String[] args) {
        Mohemby b = new Mohemby("PINCFLOID", 5);

        Persona[] persone = new Persona[PERSONE];
        Thread[] threads = new Thread[PERSONE];

        for (int i = 0; i < PERSONE; i++) {
            persone[i] = new Persona(NOMI[i], b);
            threads[i] = new Thread(persone[i]);
        }

        for (int i = 0; i < PERSONE; i++) {
            threads[i].start();
            
        }
        
    }
}