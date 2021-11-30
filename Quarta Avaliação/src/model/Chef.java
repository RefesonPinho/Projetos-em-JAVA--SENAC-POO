package model;

// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Chef a partir da herança da classe Pai que é a classe Pessoass.
public class Chef extends Pessoass {
    
    /// Encapsulando os atributos e criando collection com ArrayList através do relacionamento de classes.
    private int idChef;
    private String especialidade;
    private ArrayList<Receita> receitas = new  ArrayList <>(); 

    // Criando o construtor da classe Chef.
    public Chef(
        String nome,
        String cpf,
        String dataNascimento,
        int idChef,
        String especialidade
        
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoass.
        super(nome, cpf, dataNascimento);
        this.idChef = idChef;
        this.especialidade = especialidade; 
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setIdChef(int idChef){
        this.idChef = idChef;
    }

    public int getIdChef(){
        return this.idChef;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public String getEspecialidade(){
        return this.especialidade;
    }
    
    public void setReceita( Receita receita){
        this.receitas.add(receita);      
    }
    
    public ArrayList<Receita> getReceita(){
        return this.receitas;
    }


    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object c) {
        if (c == this)
            return true;
        if (!(c instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) c;
        return Objects.equals(this.getCPF(), chef.getCPF());
    }

    @Override
    public String toString() {
        return   "Chef :" 
            + getNome() + " / " + "CPF:"
            + getCPF() + " / " + "Data de Nascimento:" 
            + getDataNascimento() + " / " + "Id do Chefe:" 
            + getIdChef() + " / " + "Especialidade:"
            + getEspecialidade();
    }
}

