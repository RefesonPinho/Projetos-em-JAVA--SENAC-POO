// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

//Criando a classe Correntista a partir da herança da classe Pai que é a classe Pessoaa.
public class Correntista extends Pessoaa {
    // Encapsulando o atributo dataInicio e criando collections com ArrayLists através do relacionamento de classes
    private String dataInicio;
    ArrayList <Corrente> correntes = new ArrayList <>();
    ArrayList <Investimento> investimentos = new ArrayList <>();
    
    // Criando o construtor da classe Correntista
    public Correntista(
        String nome,
        String CPF,
        String dataaNascimento,
        String dataInicio,
        Corrente corrente,
        Investimento investimento
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoa
        super(nome, CPF, dataaNascimento);
        this.dataInicio = dataInicio;
        this.setCorrente(corrente);
        this.setInvestimento(investimento); 
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setDataInicio(String dataInicio){
        this.dataInicio = dataInicio;
    }

    public String getDataInicio(){
        return this.dataInicio;
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
    public boolean equals(Object c) {
        if (c == this)
            return true;
        if (!(c instanceof Correntista)) {
            return false;
        }
        Correntista correntista = (Correntista) c;
        return Objects.equals(this.getCPF(), correntista.getCPF());
    }


    @Override
    public String toString() {
        return "{" +
            " Nome='" + getNome() + "'" +
            ", CPF='" + getCPF() + "'" +
            ", data de Nascimento='" + getdataaNascimento() + "'" +
            ", data Inicio='" + getDataInicio() + "'" +
            "}";
    }
}
