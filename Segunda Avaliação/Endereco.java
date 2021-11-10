public class Endereco {
    String id;
    String cep;
    String rua;
    int numero;
    String bairro;
    String cidade; 
    Padaria padaria;

    public Endereco(

        String id,
        String cep,
        String rua,
        int numero,
        String bairro,
        String cidade, 
        Padaria padaria
    ){
       this.id = id;
       this.cep = cep;
       this.rua = rua;
       this.numero = numero;
       this.bairro = bairro;
       this.cidade = cidade;
       this.padaria = padaria;
    }
}  

    

