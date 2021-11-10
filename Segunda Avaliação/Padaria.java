<<<<<<< HEAD:Terceira Avaliação/Padaria.java
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
    


=======
import java.util.ArrayList;

public class Padaria {

    String id;
    String nome;
    String datadeabertura;
    Endereco endereco;
    ArrayList <Receita> pratos = new ArrayList<>();

    public Padaria(

        String id,
        String nome,
        String datadeabertura,
        String idendereco,
        String cep,
        String rua,
        int numero,
        String bairro,
        String cidade  
    ){
        this.id = id;
        this.nome = nome;
        this.datadeabertura = datadeabertura;
        this.endereco = new Endereco(idendereco, cep, rua, numero, bairro, cidade,this);
    }

    public void adicionarReceita(Receita receita){
        this.pratos.add(receita);
    }   
}

>>>>>>> a7dbb1bf91c3e34d84e33c2f51ea35044cd80e29:Segunda Avaliação/Padaria.java
    