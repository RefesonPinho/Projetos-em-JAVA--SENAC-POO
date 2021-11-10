import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoass {
    private String telefone;
    private ArrayList<Receita> receitas = new  ArrayList <>();
    
    public Cliente(
        String nome,
        String cpf,
        String dataNascimento,
        String telefone
    ){
        super(nome, cpf, dataNascimento);
        this.telefone = telefone;
    }

    public void setTelefone( String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
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
        if (!(c instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) c;
        return Objects.equals(this.getCPF(), cliente.getCPF());
    }

    @Override
    public String toString() {
        return   "Nome :" 
            + getNome() + " / " + "CPF:"
            + getCPF() + " / " + "Data de Nascimento:" 
            + getDataNascimento() + " / " + "Telefone:" 
            + getTelefone();
    }
}