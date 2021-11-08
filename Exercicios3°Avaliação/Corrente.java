// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Corrente a partir da herança da classe Pai que é a classe Conta.
public class Corrente extends Conta {
    /// Encapsulando o atributo carteira e criando collections com ArrayLists através do relacionamento de classes
    private String historico;
    ArrayList <Correntista> correntistas = new ArrayList <>();
    ArrayList <Gerente> gerentes = new ArrayList <>();
    
    // Criando o construtor da classe Corrente
    public Corrente(
        String agencia,
        String conta,
        String saldo,
        String historico
    ){
        // Chamando o método da super classe que pertence a classe Pai Conta
        super(agencia, conta, saldo);
        this.historico = historico;
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void sethistorico(String historico){
        this.historico = historico;
    }

    public String gethistorico(){
        return this.historico;
    }

    public void setCorrentista(Correntista correntista){
        this.correntistas.add(correntista);
    }

    public ArrayList<Correntista> getCorrentista(){
        return this.correntistas;
    } 
    
    
    public void setGerente(Gerente gerente){
        this.gerentes.add(gerente);
    }

    public ArrayList<Gerente> getGerente(){
        return this.gerentes;
    }   

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Corrente)) {
            return false;
        }
        Corrente corrente = (Corrente) o;
        return Objects.equals(this.getConta(), corrente.getConta());
    }

    
    @Override
    public String toString() {
        return "{" +
            "Agencia:" + getAgencia() + " / " +
            "Conta:" + getConta()+ " / " +
            "Saldo:" + getSaldo() + " / " +
            "Histórico:" + gethistorico() +
            "}";    
    }

    public String entrada() {
        String ret = super.entrada()
            + "\nHistorico: " + this.gethistorico();   
        return ret;
    }

    public String saida() {
        String ret = super.saida()
            + "\nHistorico: " + this.gethistorico();   
        return ret;
    }
}
