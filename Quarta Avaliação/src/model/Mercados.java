package model;

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


    public static Mercados dadosMercadosum() throws Exception {
        Mercados mercadoum = new Mercados("142","Mercado  Silva","03/07/2014", "Joinville","Floresta","223698-74","Rua dos Pardais", 124, "Comproum duas peças de cada item leva uma 0800");
        mercadoum.setReceita(Receita.dadosReceitaum());
        mercadoum.setReceita(Receita.dadosReceitadois());
        mercadoum.setReceita(Receita.dadosReceitadez());
        mercadoum.setReceita(Receita.dadosReceitasete());
        mercadoum.setReceita(Receita.dadosReceitatres());
        return mercadoum;
    }

    public static Mercados dadosMercadosdois() throws Exception {
        Mercados mercadodois = new Mercados("748","Mercado da Mônica","25/04/2010", "Joinville","Costa e Silva","147896-14","Rua das Flores", 478, "Dia dos salgados e doces por metade do preço");
        mercadodois.setReceita(Receita.dadosReceitaum());
        mercadodois.setReceita(Receita.dadosReceitaoito());
        mercadodois.setReceita(Receita.dadosReceitanove());
        mercadodois.setReceita(Receita.dadosReceitaquatro());
        mercadodois.setReceita(Receita.dadosReceitaseis());
        return mercadodois;
    }

    public static Mercados dadosMercadostres() throws Exception{
        Mercados mercadotres = new Mercados("142","Mercado do Povo","03/07/2014", "Joinville","Centro","223698-74","Rua das Pedras", 791, "A cada dez peças compradas leva 5");
        mercadotres.setReceita(Receita.dadosReceitaum());
        mercadotres.setReceita(Receita.dadosReceitaoito());
        mercadotres.setReceita(Receita.dadosReceitanove());
        mercadotres.setReceita(Receita.dadosReceitaquatro());
        mercadotres.setReceita(Receita.dadosReceitaseis());
        return mercadotres;
    }
}