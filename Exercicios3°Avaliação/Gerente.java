// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

//Criando a classe Gerente a partir da herança da classe Pai que é a classe Pessoaa.
public class Gerente extends Pessoaa{
    // Encapsulando o atributo dataInicio e criando collections com ArrayLists através do relacionamento de classes
    private String cargo;
    ArrayList <Corrente> correntes = new ArrayList <>();
    ArrayList <Investimento> investimentos = new ArrayList <>();

    // Criando o construtor da classe Correntista
    public Gerente(
        String nome,
        String CPF,
        String dataaNascimento,
        String cargo,
        Corrente corrente,
        Investimento investimento
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoa
        super(nome, CPF, dataaNascimento);
        this.cargo = cargo;
        this.setCorrente(corrente);
        this.setInvestimento(investimento);
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setCorrente(Corrente corrente){
        this.correntes.add(corrente);
    }

    public ArrayList<Corrente> getCorrente(){
        return this.correntes;
    } 
    
    
    public void setInvestimento(Investimento investimento){
        this.investimentos.add(investimento);
    }

    public ArrayList<Investimento> getInvestimento(){
        return this.investimentos;
    }
    
    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object g) {
        if (g == this)
            return true;
        if (!(g instanceof Gerente)) {
            return false;
        }
        Gerente gerente = (Gerente) g;
        return Objects.equals(this.getCPF(), gerente.getCPF());
    }


    @Override
    public String toString() {
        return "Nome:" 
            + getNome() + " / " + "CPF:"
            + getCPF() + " / " + "Data de nascimento:" 
            + getdataaNascimento() + " / " + "Cargo:" 
            + getCargo();    
    }
}
