package model;

import java.util.Objects;

public class Jaula {
    private int jaula_id;
    private String descricao;

    public Jaula(int jaula_id, String descricao) {
        this.jaula_id = jaula_id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return jaula_id;
    }

    public void setIdJaula(int jaula_id) {
        this.jaula_id = jaula_id;
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
