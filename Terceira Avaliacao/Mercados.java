// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Mercados a partir da herança da classe Pai que é a classe Estabelecimento.
public class Mercados extends Estabelecimento{
    
    /// Encapsulando os atributos e criando collection com ArrayList através do relacionamento de classes.
    private String promocao;
    private ArrayList <Receita> pratos = new ArrayList<>();

    // Criando o construtor da classe Mercados
    public Mercados(
        String idAlvara,
        String nomeEstabelecimento,
        String datadeabertura,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        String promocao
        
    ){
        // Chamando o método da super classe que pertence a classe Pai Estabelecimento.
        super(idAlvara, nomeEstabelecimento, datadeabertura, cidade, bairro, cep, rua, numero);
        this.promocao = promocao;
        
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados. 
    public void setPromocao(String promocao){
        this.promocao = promocao;
    }

    public String getPromocao(){
        return this.promocao;
    }

    public void setReceita(Receita receita){
        this.pratos.add(receita);
    }
    
    public ArrayList<Receita> getReceita(){
        return this.pratos;
    }  

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object m) {
        if (m == this)
            return true;
        if (!(m instanceof Mercados)) {
            return false;
        }
        Mercados mercados = (Mercados) m;
        return Objects.equals(this.getIdAlvara(), mercados.getIdAlvara());
    }

    @Override
    public String toString() {
        String total="\nEstabelecimento: " 
            + getNomeEstabelecimento()+ " / " + " Id de Alvara:"
            + getIdAlvara() + " / " + " Data de abertura:" 
            + getDataAbertura() + " / " + " Cidade:" 
            + getEndereco().getCidade() + " / " + " Bairro:"
            + getEndereco().getBairro() + " / " + " Cep:"
            + getEndereco().getCep() + " / " + " Rua:"  
            + getEndereco().getRua() + " / " + " Número:"
            + getEndereco().getNumero() + " / " + " Promoção:" 
            + getPromocao() + "\n"  + "Quantidade de Receitas no "
            + getNomeEstabelecimento() + " é:"
            + this.pratos.size() + "\n";
            
            for(Receita receita : this.pratos){
                total += "\n   "+ receita.dadosReceita();

            };
        return total;    
    }
}