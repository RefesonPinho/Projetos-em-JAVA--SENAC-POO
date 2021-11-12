// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Padaria a partir da herança da classe Pai que é a classe Estabelecimento.
public class Padaria extends Estabelecimento {
    /// Encapsulando os atributos e criando collection com ArrayList através do relacionamento de classes.
    private String horarioFuncionamento;
    private ArrayList <Receita> pratos = new ArrayList<>();

    // Criando o construtor da classe Padaria
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
        // Chamando o método da super classe que pertence a classe Pai Estabelecimento.
        super(idAlvara, nomeEstabelecimento, datadeabertura, cidade, bairro, cep, rua, numero);
        this.horarioFuncionamento = horarioFuncionamento;
    
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.  
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
        String total="\nEstabelecimento: " 
            + getNomeEstabelecimento()+ " / " + "Id de Alvara:"
            + getIdAlvara() + " / " + "Data de abertura:" 
            + getDataAbertura() + " / " + "Cidade:" 
            + getEndereco().getCidade() + " / " + "Bairro:"
            + getEndereco().getBairro() + " / " + "Cep:"
            + getEndereco().getCep() + " / " + "Rua:"  
            + getEndereco().getRua() + " / " + "Número:"
            + getEndereco().getNumero() + " / " + "Horário de funcionamento:" 
            + getHorarioFuncionamento() + "\n"  + "Quantidade de Receitas na "
            + getNomeEstabelecimento() + " é:"
            + this.pratos.size() + "\n";
            
            for(Receita receita : this.pratos){
                total += "\n   "+ receita.dadosReceita();

            };
        return total;    
    }
    
}
    


    