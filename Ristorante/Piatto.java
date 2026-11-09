package Ristorante;

public class Piatto {
    private final String nome;
    private final int prezzo;
    private boolean isMangiato;

    public Piatto(String nome, int prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
        isMangiato = false;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public boolean isMangiato() {
        return isMangiato;
    }

    public void mangia() {
        this.isMangiato = true;
    }

}