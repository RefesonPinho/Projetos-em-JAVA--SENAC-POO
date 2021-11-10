import java.util.ArrayList;
import java.util.Objects;

public class Chef extends Pessoass {
    
    private String idChef;
    private String especialidade;
    private ArrayList<Receita> receitas = new  ArrayList <>(); 

    public Chef(
        String nome,
        String cpf,
        String dataNascimento,
        String idChef,
        String especialidade
        
    ){
        super(nome, cpf, dataNascimento);
        this.idChef = idChef;
        this.especialidade = especialidade; 
    }

    public void setIdChef(String idChef){
        this.idChef = idChef;
    }

    public String getIdChef(){
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
        return   "Nome :" 
            + getNome() + " / " + "CPF:"
            + getCPF() + " / " + "Data de Nascimento:" 
            + getDataNascimento() + " / " + "Id do Chefe:" 
            + getIdChef() + " / " + "Especialidade:"
            + getEspecialidade();
    }

    
}

