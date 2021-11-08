//Criando a classe Pai Conta
public class Conta {
    // Encapsulando os atributos ou propriedades
    private String agencia;
    private String conta;
    private String saldo;

    // Criando o contrutor da classe Conta
    protected Conta(
        String agencia,
        String conta,
        String saldo
    ){
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    protected void setAgencia(String agencia){
        this.agencia = agencia;
    }

    protected String getAgencia(){
        return this.agencia;
    }

    protected void setConta(String conta){
        this.conta = conta;
    }

    protected String getConta(){
        return this.conta;
    }

    protected void setSaldo(String saldo){
        this.saldo = saldo;
    }

    protected String getSaldo(){
        return this.saldo;
    }


    public String entrada(){
        return "Entrou na conta o de R$ :" + this.getSaldo();
    }

    public String saida(){
        return "Foi retirada da conta" + this.conta + "o valor de:" + this.getSaldo();
    }
}
