// Importando as bibliotecas padrões e as packages.
package src.model;
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Golfinho a partir da herança da classe Pai que é a classe Animal
public class Golfinho extends Animal {
    private int treinamento;
    private Jaula jaula;
    private ArrayList<Treinamento> treinamentos = new  ArrayList <>();
    // Criando as classes construtora de Golfinho fazendo uso do POLIMORFISMO
    public Golfinho(
        int id,
        String nome,
        int treinamento,
       int idJaula
    ){
       super(id, nome);
    }

    public Golfinho(
        String nome,
        int treinamento,
        int idJaula
    ){
       super(nome);
       this.treinamento = treinamento;
       this.jaula = new Jaula(idJaula);
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public int getTreinamento() {
        return treinamento;
    }
    public Jaula getJaula() {
        return jaula;
    }
    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }
    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public ArrayList<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(ArrayList<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object g) {
        if (g == this)
            return true;
        if (!(g instanceof Golfinho)) {
            return false;
        }
        Golfinho golfinho = (Golfinho) g;
        return Objects.equals(this.getIdAnimal(), golfinho.getIdAnimal());
    }

    @Override
    public String toString() {
        return   "Id :" 
            + getIdAnimal() + " / " + "Nome:"
            + getNome() + " / " + "Treinamento:" 
            + getTreinamento() + " / " + "Jaula:"
            + getJaula().getIdJaula();

    }

}
