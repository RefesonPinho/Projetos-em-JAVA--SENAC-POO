package model;

import java.util.Objects;

public class Golfinho extends Animal {
    private int treinamento;
    private Jaula jaula;

    public Golfinho(int id, String nome,int treinamento, int jaula_id, String descricao) {
        super(id, nome);
        this.setTreinamento(treinamento);
        this.jaula = new Jaula(jaula_id, descricao);
    }

    public Golfinho(String nome,int treinamento, int jaula_id, String descricao) {
        super(0, nome);
        this.setTreinamento(treinamento);
        this.jaula = new Jaula(jaula_id, descricao);
    }


    public int getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    public Golfinho id(int id) {
        setIdAnimal(id);
        return this;
    }

    public Golfinho nome(String nome) {
        setNome(nome);
        return this;
    }

    public Golfinho treinamento(int treinamento) {
        setTreinamento(treinamento);
        return this;
    }

    public Golfinho jaula(Jaula jaula) {
        setJaula(jaula);
        return this;
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
        return Objects.equals(this.getNome(), golfinho.getNome());
    }
    
    @Override
    public String toString() {
        return   "IdAnimal:" 
            + getIdAnimal() + " / " + "Nome"
            + getNome() + " / " + "Treinamento:"
            + getTreinamento()+ " / " + "Jaula:"
            + getJaula();
    }
}
