import java.util.ArrayList;
import java.util.Objects;

public class Investimento extends Conta {
    private String carteira;
    ArrayList <Correntista> correntistas = new ArrayList <>();
    ArrayList <Gerente> gerentes = new ArrayList <>();

    public Investimento(
        String agencia,
        String conta,
        String saldo,
        String carteira
    ){
        super(agencia, conta, saldo);
        this.carteira = carteira;
    }

    public void setCarteira(String carteira){
        this.carteira = carteira;
    }

    public String getCarteira(){
        return this.carteira;
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
    public boolean equals(Object i) {
        if (i == this)
            return true;
        if (!(i instanceof Investimento)) {
            return false;
        }
        Investimento investimento= (Investimento) i;
        return Objects.equals(this.getConta(), investimento.getConta());
    }

    @Override
    public String toString() {
        return "{" +
            "Agencia:" + getAgencia() + " / " +
            "Conta:" + getConta()+ " / " +
            "Saldo:" + getSaldo() + " / " +
            "Carteira:" + getCarteira() +
            "}";     
    }

    public String entrada() {
        String val = super.entrada()
            + "\nHistorico: " + this.getCarteira();   
        return val;
    }

    public String saida() {
        String val = super.saida()
            + "\nHistorico: " + this.getCarteira();   
        return val;
    }
}
