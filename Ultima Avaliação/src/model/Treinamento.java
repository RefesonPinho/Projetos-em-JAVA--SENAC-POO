package model;

import java.sql.Date;

public class Treinamento {
    private int id;
    private Date data;
    private String detalhes;
    private Golfinho golfinho;
    
    public Treinamento(int id, Date data, String detalhes, Golfinho golfinho) {
        this.setIdTreinamento(id);
        this.setDataTrei(data);
        this.setDetalhes(detalhes);
        this.setGolfinho(golfinho);
    }

    public Golfinho getGolfinho() {
        return golfinho;
    }

    public void setGolfinho(Golfinho golfinho) {
        this.golfinho = golfinho;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Date getDataTrei() {
        return data;
    }

    public void setDataTrei(Date data) {
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
