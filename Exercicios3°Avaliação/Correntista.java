import java.util.ArrayList;
import java.util.Objects;

public class Correntista extends Pessoaa {
    private String dataInicio;
    ArrayList <Corrente> correntes = new ArrayList <>();
    ArrayList <Investimento> investimentos = new ArrayList <>();
    


    public Correntista(
        String nome,
        String CPF,
        String dataaNascimento,
        String dataInicio,
        Corrente corrente,
        Investimento investimento
    ){
        super(nome, CPF, dataaNascimento);
        this.dataInicio = dataInicio;
        this.setCorrente(corrente);
        this.setInvestimento(investimento); 
    }

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
