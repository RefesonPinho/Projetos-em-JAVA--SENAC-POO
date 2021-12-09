package src.model;

import java.sql.Date;

public class Treinamento {
    private int id;
    private Date data;
    private String detalhes;
    
    public Treinamento(Date data, String detalhes) {
        this.data = data;
        this.detalhes= detalhes;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Date getDataTreinamento() {
        return data;
    }

    public void setDataTreino(Date data) {
        this.data = data;
    }

    public int getIdTreinamento() {
        return id;
    }

    public void setIdTreinamento(int id ) {
        this.id = id;
    }

    public Date getUltimoTreino(){
        return data;
    } 
}
