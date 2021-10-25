import java.util.ArrayList;

public class Geladeira {
    
    String cor;
    String marca;
    int altura;
    int largura;
    int capacidade;
    ArrayList<Fruta> frutas = new ArrayList<>();

    public Geladeira(
        String cor,
        String marca,
        int altura,
        int largura,
        int capacidade
    ) {
        this.cor = cor;
        this.marca = marca;
        this.altura = altura;
        this.largura = largura;
        this.capacidade = capacidade;
    }
    
    public void adicionarFruta(Fruta fruta) {
        this.frutas.add(fruta);
    }

    public void adicionarFruta(
        String tipo,
        String nomeCientifico,
        String vitaminas
    ) {
        this.adicionarFruta(new Fruta(tipo, nomeCientifico, vitaminas));
    }

}
