package src.model;
import java.sql.Date;


public class Alimentacao {
    private int id;
    private int leaoId;
    private Date dataAlimentacao;
    private String detalhes;
    private Leao leao;

    public Alimentacao(
        int id,
        int leaoId,
        Date dataAlimentacao,
        String detalhes
    ){
        this.id = id;
        this.leaoId = leaoId;
        this.dataAlimentacao = dataAlimentacao;
        this.detalhes = detalhes;  
    }

    public Alimentacao(
        int id,
        Date dataAlimentacao,
        String detalhes
    ){
        this.id = id;
        this.dataAlimentacao = dataAlimentacao;
        this.detalhes = detalhes;  
    }

    public Date getDataAlimentacao() {
        return dataAlimentacao;
    }

    public void setDataAlimentacao(Date dataAlimentacao) {
        this.dataAlimentacao = dataAlimentacao;
    }

    public int getLeaoId() {
        return leaoId;
    }

    public void setLeaoId(int leaoId) {
        this.leaoId = leaoId;
    }

    public int getIdAlimentacao() {
        return id;
    }

    public void setIdAlimentacao(int id) {
        this.id = id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Leao getLeao() {
        return leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
    }


    
}
