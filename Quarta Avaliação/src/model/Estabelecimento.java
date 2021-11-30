package model;

// Importandos biblioteca padrão.
import java.util.Objects;

//Criando a classe Pai Estabelecimento
public class Estabelecimento{

    // Encapsulando os atributos
    private String idAlvara;
    private String nomeEstabelecimento;
    private String datadeabertura;
    private Endereco endereco;

    // Criando o construtor da classe Estabelecimento
    protected Estabelecimento(
        String idAlvara,
        String nomeEstabelecimento,
        String datadeabertura,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero
    ){
        this.idAlvara = idAlvara;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.datadeabertura = datadeabertura;
        this.endereco = new Endereco(cidade, bairro, cep, rua, numero,this);
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    protected void setIdAlvara(String idAlvara){
        this.idAlvara = idAlvara;
    }

    protected String getIdAlvara(){
        return this.idAlvara;
    }

    protected void setNomeEstabelecimento(String nomeEstabelecimento){
        this.nomeEstabelecimento = nomeEstabelecimento;
    }
    
    protected String getNomeEstabelecimento(){
        return this.nomeEstabelecimento;
    }

    protected void setDataAbertura(String datadeabertura){
        this.datadeabertura = datadeabertura;
    }

    protected String getDataAbertura(){
        return this.datadeabertura;
    }

    protected void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    protected Endereco getEndereco(){
        return this.endereco;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object e) {
        if (e == this)
            return true;
        if (!(e instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento estabelecimento = (Estabelecimento) e;
        return Objects.equals(this.getIdAlvara(), estabelecimento.getIdAlvara());
    }

    
    @Override
    public String toString() {
        return   "Id do Alvará:" 
            + getIdAlvara() + " / " + "Nome do Estabelecimento:"
            + getNomeEstabelecimento() + " / " + "Data de abertura:" 
            + getDataAbertura() + " / " + "Cidade:" 
            + getEndereco().getCidade() + " / " + "Bairro:"
            + getEndereco().getBairro() + " / " + "Cep:"
            + getEndereco().getCep() + " / " + "Rua:"  
            + getEndereco().getRua() + " / " + "Número:"
            + getEndereco().getNumero();
    }
}