import java.util.ArrayList;

public class Receita {

    String idreceita;
    String nomereceita;
    String etapas;
    int numeroetapas; 
    Chef chef;
    ArrayList <Padaria> padaria = new ArrayList<>();

    public Receita(

        String idreceita,
        String nomereceita,
        String etapas,
        int numeroetapas,
        String idchefe,
        String nome,
        String cpf,
        String datanascimento
    ){
        this.idreceita = idreceita;
        this.nomereceita = nomereceita;
        this.etapas = etapas;
        this.numeroetapas = numeroetapas;
        this.chef = new Chef(idchefe, nome, cpf, datanascimento);
    }
        
    public void adicionarPadaria(Padaria padaria){
        this.padaria.add(padaria);   
    }
}

