import java.util.ArrayList;

public class Chef {
    
    String idchefe;
    String nome;
    String cpf;
    String datanascimento;
    ArrayList<Receita> receitas = new  ArrayList <>(); 

    public Chef(
        String idchefe,
        String nome,
        String cpf,
        String datanascimento
    ){

       this.idchefe = idchefe;
       this.nome = nome;
       this.cpf = cpf;
       this.datanascimento = datanascimento; 
    }
    
    public void adicionarReceita( Receita receita){
        this.receitas.add(receita);      
    } 
}

