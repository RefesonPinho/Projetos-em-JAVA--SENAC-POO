package model;

import java.sql.Date;

public class Alimentacao {
    private int id;
    private Date data;
    private String detalhes;
    private Leao leao;
    
    public Alimentacao(int id, Date data, String detalhes, Leao leao) {
        this.setIdAlimentacao(id);
        this.setData(data);
        this.setDetalhes(detalhes);
        this.setLeao(leao);
    }

    public Leao getLeao() {
        return leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdAlimentacao() {
        return id;
    }

    public void setIdAlimentacao(int id) {
        this.id = id;
    }

}
