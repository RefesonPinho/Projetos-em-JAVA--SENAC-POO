import java.util.ArrayList;
import java.util.Objects;

public class Gerente extends Pessoaa{
    private String cargo;
    ArrayList <Corrente> correntes = new ArrayList <>();
    ArrayList <Investimento> investimentos = new ArrayList <>();

    public Gerente(
        String nome,
        String CPF,
        String dataaNascimento,
        String cargo,
        Corrente corrente,
        Investimento investimento
    ){
        super(nome, CPF, dataaNascimento);
        this.cargo = cargo;
        this.setCorrente(corrente);
        this.setInvestimento(investimento);
    }

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
