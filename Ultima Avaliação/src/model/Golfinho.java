package src.model;
import java.util.ArrayList;

public class Golfinho extends Animal {
    private int treinamento;
    private Jaula jaula;
    private ArrayList<Treinamento> treinamentos = new  ArrayList <>();

    public Golfinho(
        int id,
        String nome,
        int treinamento,
       int idJaula
    ){
       super(id, nome);
    }

    public Golfinho(
        String nome,
        int treinamento,
        int idJaula
    ){
       super(nome);
       this.treinamento = treinamento;
       this.jaula = new Jaula(idJaula);
    }


    public int getTreinamento() {
        return treinamento;
    }
    public Jaula getJaula() {
        return jaula;
    }
    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }
    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public ArrayList<Treinamento> getTreinamentos() {
        return treinamentos;
    }

    public void setTreinamentos(ArrayList<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

}
