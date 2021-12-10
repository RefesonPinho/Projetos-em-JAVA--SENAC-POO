package src.model;

public class Jaula {
    private int idJaula;
    private String descricao;

    public Jaula(
        int idJaula,
        String descricao
    ){
        this.idJaula = idJaula;
        this.descricao = descricao;
    }

    public Jaula(
        int idJaula
    ){
        this.idJaula = idJaula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(int idJaula) {
        this.idJaula = idJaula;
    }

    public Jaula IdJaula(int idJaula) {
        setIdJaula(idJaula);
        return this;
    }

    public Jaula descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }
}
