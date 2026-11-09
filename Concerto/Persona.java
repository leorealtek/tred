package Concerto;

public class Persona implements Runnable {
    private final String nome;
    private final Mohemby mohemby;

    public Persona(String nome, Mohemby mohemby) {
        this.nome = nome;
        this.mohemby = mohemby;
    }

    @Override
    public void run() {
        System.out.println(nome + ((mohemby.prenota()) ? "" : " non") + " è riuscito a prenotare");
    }

    public String getNome() {
        return nome;
    }

    public Mohemby getMohemby() {
        return mohemby;
    }

}