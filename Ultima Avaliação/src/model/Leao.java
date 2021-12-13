// Importando as bibliotecas padrões e as packages.
package src.model;
import java.util.Objects;
import java.util.ArrayList;

// Criando a classe Cliente a partir da herança da classe Pai que é a classe Animal
public class Leao extends Animal {
    private int alimentacao = 6;
    private int visitantes;
    private Jaula jaula;
    private ArrayList<Alimentacao> alimentacoes = new  ArrayList <>();
    // Criando as classes construtora de Treinamento fazendo uso do POLIMORFISMO
    public Leao(
        int id,
        String nome,
        int alimentacao,
        int visitantes,
        int idJaula
       
    ){
        super(id, nome);
        this.alimentacao = alimentacao;
        this.visitantes =visitantes;
        this.jaula = new Jaula(idJaula);
    }

    public Leao(
        String nome,
        int alimentacao,
        int visitantes,
        int idJaula
        
    ){
        super(nome);
        this.alimentacao = alimentacao;
        this.visitantes =visitantes;
        this.jaula = new Jaula(idJaula);
        
    }
    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.

    public int getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }

    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public void adicionarAlimentacao(Alimentacao alimentacao) {
        this.alimentacoes.add(alimentacao);
    }

    public void setAlimentacao(Alimentacao alimentacao) {
        this.alimentacoes.add(alimentacao);
    }    

    public ArrayList<Alimentacao> getAlimentacoes() {
        return alimentacoes;
    }


    public void setAlimentacoes(ArrayList<Alimentacao> alimentacoes) {
        this.alimentacoes = alimentacoes;
    }

    public Leao alimentacao(int alimentacao) {
        setAlimentacao(alimentacao);
        return this;
    }

    public Leao visitantes(int visitantes) {
        setVisitantes(visitantes);
        return this;
    }

    public Leao id(int id) {
        setIdAnimal(id);
        return this;
    }

    public Leao nome(String nome) {
        setNome(nome);
        return this;
    }

    public Leao Jaulaid(Jaula jaula) {
        setJaula(jaula);
        return this;
    }


    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object l) {
        if (l == this)
            return true;
        if (!(l instanceof Leao)) {
            return false;
        }
        Leao leao = (Leao) l;
        return Objects.equals(this.getIdAnimal(), leao.getIdAnimal());
    }

    @Override
    public String toString() {
        return   "Id :" 
            + getIdAnimal() + " / " + "Nome:"
            + getNome() + " / " + "Alimentacao:" 
            + getAlimentacao()+ " / " + "Visitantes:" 
            + getVisitantes() + " / " + "Jaula:"
            + getJaula().getIdJaula();

    }
    
}
