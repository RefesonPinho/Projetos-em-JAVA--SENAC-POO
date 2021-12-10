package src.model;
import java.sql.Date;

public class Treinamento {
    private int id;
    private int golfinhoId;
    private Date dataTreino;
    private String detalhesTreino;
    private Golfinho golfinho;

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
}
