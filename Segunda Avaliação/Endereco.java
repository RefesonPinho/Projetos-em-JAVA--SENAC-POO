public class Endereco {
    private String cidade;
    private String bairro;
    private String cep;
    private String rua;
    private int numero;
    private Estabelecimento estabelecimento; 
    
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
}  


    

