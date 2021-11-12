// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Cliente a partir da herança da classe Pai que é a classe Pessoass.
public class Cliente extends Pessoass {
    /// Encapsulando os atributos e criando collection com ArrayList através do relacionamento de classes.
    private String telefone;
    private ArrayList<Receita> receitas = new  ArrayList <>();

    // Criando o construtor da classe Cliente.
    public Cliente(
        String nome,
        String cpf,
        String dataNascimento,
        String telefone
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoass.
        super(nome, cpf, dataNascimento);
        this.telefone = telefone;
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
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
    
    // Fazendo uso do padrão de projeto Decorator 
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
        String total="\nCliente: " 
            + getNome()+ " / " + "CPF:"
            + getCPF() + " / " + " Data de nascimento:" 
            + getDataNascimento() + " / " + "Telefone:" 
            + getTelefone() + "\n"  + "Quantidade de Receitas compradas por "
            + getNome() + " é:"
            + this.receitas.size() + "\n";
            
            for(Receita receita : this.receitas){
                total += "\n   "+ receita.getNomeReceita();
                

            };
        return total;    
    }
}