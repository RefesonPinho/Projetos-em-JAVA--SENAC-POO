package model;

import java.util.Objects;

// Criando a classe Endereço
public class Endereco {
    /// Encapsulando os atributos
    private String cidade;
    private String bairro;
    private String cep;
    private String rua;
    private int numero;
    private Estabelecimento estabelecimento; 

    // Criando o construtor da classe Endereço
    public Endereco(
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        Estabelecimento estabelecimento
       
    ){
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.estabelecimento = estabelecimento;    
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCidade(){
        return this.cidade;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getBairro(){
        return this.bairro;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public String getCep(){
        return this.cep;
    }

    public void setRua(String rua){
        this.rua = rua;
    }

    public String getRua(){
        return this.rua;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }
    
    public void setEstabelecimento(Estabelecimento estabelecimento){
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento(){
        return this.estabelecimento;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object e) {
        if (e == this)
            return true;
        if (!(e instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) e;
        return Objects.equals(this.getNumero(), endereco.getNumero());
    }

    
    @Override
    public String toString() {
        return   "Cidade: " 
            + getCidade() + " / " + "Bairro:"
            + getBairro() + " / " + "Cep:"
            + getCep() + " / " + "Rua:" 
            + getRua() + " / " + "Numero:" 
            + getNumero();
    }
}  


    

