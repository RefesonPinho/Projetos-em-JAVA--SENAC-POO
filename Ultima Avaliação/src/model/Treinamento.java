// Importando as bibliotecas padrões e as packages.
package src.model;
import java.sql.Date;
import java.util.Objects;

// Criando a classe Treinamento
public class Treinamento {
    private int id;
    private int golfinhoId;
    private Date dataTreino;
    private String detalhesTreino;
    private Golfinho golfinho;
    
    // Criando as classes construtora de Treinamento
    public Treinamento(
        int id,
        int golfinhoId,
        Date dataTreino,
        String detalhesTreino

    ){
        this.id = id;
        this.golfinhoId = golfinhoId;
        this.dataTreino = dataTreino;
        this.detalhesTreino = detalhesTreino;
    }
    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.

    public Golfinho getGolfinho() {
        return golfinho;
    }

    public void setGolfinho(Golfinho golfinho) {
        this.golfinho = golfinho;
    }

    public int getId() {
        return id;
    }
    public String getDetalhesTreino() {
        return detalhesTreino;
    }
    public void setDetalhesTreino(String detalhesTreino) {
        this.detalhesTreino = detalhesTreino;
    }
    public Date getDataTreino() {
        return dataTreino;
    }
    public void setDataTreino(Date dataTreino) {
        this.dataTreino = dataTreino;
    }
    public int getgolfinhoId() {
        return golfinhoId;
    }
    public void setgolfinhoId(int golfinhoId) {
        this.golfinhoId = golfinhoId;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object t) {
        if (t == this)
            return true;
        if (!(t instanceof Treinamento)) {
            return false;
        }
        Treinamento treinamento = (Treinamento) t;
        return Objects.equals(this.getId(), treinamento.getId());
    }

    @Override
    public String toString() {
        return   "Id :" 
            + getId() + " / " + "Id do Golfinho:"
            + getgolfinhoId() + " / " + "Data treino:" 
            + getDataTreino()+ " / " + "Detalhes Treino:" 
            + getDetalhesTreino();

    }
}
