import java.util.ArrayList;
import java.util.Objects;

public class Corrente extends Conta {
    private String historico;
    ArrayList <Correntista> correntistas = new ArrayList <>();
    ArrayList <Gerente> gerentes = new ArrayList <>();
    

    public Corrente(
        String agencia,
        String conta,
        String saldo,
        String historico
    ){
        super(agencia, conta, saldo);
        this.historico = historico;
    }

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
