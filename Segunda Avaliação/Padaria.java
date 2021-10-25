import java.util.ArrayList;

public class Padaria {

    String id;
    String nome;
    String datadeabertura;
    Endereco endereco;
    ArrayList <Receita> pratos = new ArrayList<>();

    public Padaria(

        String id,
        String nome,
        String datadeabertura,
        String idendereco,
        String cep,
        String rua,
        int numero,
        String bairro,
        String cidade  
    ){
        this.id = id;
        this.nome = nome;
        this.datadeabertura = datadeabertura;
        this.endereco = new Endereco(idendereco, cep, rua, numero, bairro, cidade,this);
    }

    public void adicionarReceita(Receita receita){
        this.pratos.add(receita);
    }   
}

    