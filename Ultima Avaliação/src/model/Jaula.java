package model;

import java.util.Objects;

public class Jaula {
    private int jaulaId;
    private String descricao;

    public Jaula(int jaulaId, String descricao) {
        this.jaulaId = jaulaId;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return jaulaId;
    }

    public void setIdJaula(int jaulaId) {
        this.jaulaId = jaulaId;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object j) {
        if (j == this)
            return true;
        if (!(j instanceof Jaula)) {
            return false;
        }
        Jaula jaula = (Jaula) j;
        return Objects.equals(this.getIdJaula(), jaula.getIdJaula());
    }

    
    @Override
    public String toString() {
        return   "IdJaula:" 
            + getIdJaula() + " / " + "Descricão:"
            + getDescricao();
    }
}
