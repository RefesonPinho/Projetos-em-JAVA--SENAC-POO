package model;

import java.util.Objects;

public class Leao extends Animal {
    private int alimentacao = 6;
    private int visitantes = 0;
    private Jaula jaula;

    
    public Leao(int id, String nome, int alimentacao, int visitantes, int jaulaId) {
        super(id, nome);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
        this.getJaula().setIdJaula(jaulaId);
    }

    public Leao(String nome, int alimentacao, int visitantes, int jaulaId){
        super(nome);
        this.getJaula().setIdJaula(jaulaId);
    }
    
    public int getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public int getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }

    public Jaula getJaula() {
        return jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula=jaula;
    }

    public int getUltimaAlimentacao(){
        return alimentacao;
    }

    public Leao id(int id) {
        setIdAnimal(id);
        return this;
    }

    public Leao nome(String nome) {
        setNome(nome);
        return this;
    }

    public Leao alimentacao(int alimentacao) {
        setAlimentacao(alimentacao);
        return this;
    }

    public Leao visitantes(int visitantes) {
        setVisitantes(visitantes);
        return this;
    }

    public Leao jaula(Jaula jaula) {
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
        return Objects.equals(this.getNome(), leao.getNome());
    }

    
    @Override
    public String toString() {
        return   "IdAnimal:" 
            + getIdAnimal()+ " / " + "nome:"
            + getNome() + " / " + "Alimentacão:"
            + getAlimentacao()+ " / " + "Visitantes:"
            + getVisitantes();
    }
}

