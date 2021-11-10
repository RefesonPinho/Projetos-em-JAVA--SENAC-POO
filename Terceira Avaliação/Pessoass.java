public class Pessoass{
    private String nome;
    private String cpf;
    private String dataNascimento;

    protected Pessoass(
        String nome,
        String cpf,
        String dataNascimento
    ){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }

    protected String getNome(){
        return this.nome;
    }

    protected void setCPF(String cpf){
        this.cpf = cpf;
    }

    protected String getCPF(){
        return this.cpf;
    }

    protected void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    protected String getDataNascimento(){
        return this.dataNascimento;
    }
}
