// Importando as bibliotecas padrões e as packages.
package src.model;
import java.sql.Date;
import java.util.Objects;

// Criando a classe Alimentacao
public class Alimentacao {
    private int idAlimentacao;
    private Date dataAlimentacao;
    private String detalhes;
    private Leao leao;
    // Criando as classes construtora de Treinamento fazendo uso do POLIMORFISMO
    public Alimentacao(
        int idAlimentacao,
        Date dataAlimentacao,
        String detalhes,
        Leao leao
    ){
        this.idAlimentacao = idAlimentacao;
        this.dataAlimentacao = dataAlimentacao;
        this.detalhes = detalhes;
        this.leao = leao;

        leao.setAlimentacao(this);
    }

    public Alimentacao(
        int idAlimentacao,
        Date dataAlimentacao,
        String detalhes
    ){
        this.idAlimentacao = idAlimentacao;
        this.dataAlimentacao = dataAlimentacao;
        this.detalhes = detalhes;  
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public Date getDataAlimentacao() {
        return dataAlimentacao;
    }

    public void setDataAlimentacao(Date dataAlimentacao) {
        this.dataAlimentacao = dataAlimentacao;
    }


    public int getIdAlimentacao() {
        return idAlimentacao;
    }

    public void setIdAlimentacao(int idAlimentacao) {
        this.idAlimentacao = idAlimentacao;
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

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object a) {
        if (a == this)
            return true;
        if (!(a instanceof Alimentacao)) {
            return false;
        }
        Alimentacao alimentacao = (Alimentacao) a;
        return Objects.equals(this.getIdAlimentacao(), alimentacao.getIdAlimentacao());
    }

    @Override
    public String toString() {
        return   "Id Alimentacão :" 
            + getIdAlimentacao() + " / " + "Data Alimentação:"
            + getDataAlimentacao() + " / " + "Detalhes:" 
            + getDetalhes();
    }

}
