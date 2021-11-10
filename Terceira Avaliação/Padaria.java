import java.util.ArrayList;
import java.util.Objects;

public class Padaria extends Estabelecimento {

    private String horarioFuncionamento;
    private ArrayList <Receita> pratos = new ArrayList<>();

    public Padaria(
        String idAlvara,
        String nomeEstabelecimento,
        String datadeabertura,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        String horarioFuncionamento
        
    ){
        super(idAlvara, nomeEstabelecimento, datadeabertura, cidade, bairro, cep, rua, numero);
        this.horarioFuncionamento = horarioFuncionamento;
    
    }

    public void setHorarioFuncionamento(String horarioFuncionamento){
        this.horarioFuncionamento = horarioFuncionamento;
    }
    
    public String getHorarioFuncionamento(){
        return this.horarioFuncionamento;
    }

    public void setReceita(Receita receita){
        this.pratos.add(receita);
        receita.setPadaria(this);
        
    }
    
    public ArrayList<Receita> getReceita(){
        return this.pratos;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object p) {
        if (p == this)
            return true;
        if (!(p instanceof Padaria)) {
            return false;
        }
        Padaria padaria = (Padaria) p;
        return Objects.equals(this.getIdAlvara(), padaria.getIdAlvara());
    }


    @Override
    public String toString() {
        String total="Id do Alvará:" 
            + getIdAlvara() + " / " + "Nome do Estabelecimento:"
            + getNomeEstabelecimento() + " / " + "Data de abertura:" 
            + getDataAbertura() + " / " + "Cidade:" 
            + getEndereco().getCidade() + " / " + "Bairro:"
            + getEndereco().getBairro() + " / " + "Cep:"
            + getEndereco().getCep() + " / " + "Rua:"  
            + getEndereco().getRua() + " / " + "Número:"
            + getEndereco().getNumero() + " / " + "Horário de funcionamento:"
            + getHorarioFuncionamento() + "Quantidade de Receitas:"
            + this.pratos.size();
            
            for(Receita receita : this.pratos){
                total += "\n   "+ receita.dadosReceita();

            };
        return total;    
    }
    
}
    


    