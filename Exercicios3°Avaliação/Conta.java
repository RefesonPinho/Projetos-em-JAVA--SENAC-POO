public class Conta {
    private String agencia;
    private String conta;
    private String saldo;

    protected Conta(
        String agencia,
        String conta,
        String saldo
    ){
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

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
