public class Endereco {
    String cep;
    String rua;
    String numero;
    String bairro;
    String cidade;
    String estado;
    String pais;

    public Endereco(
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String pais
    ) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
