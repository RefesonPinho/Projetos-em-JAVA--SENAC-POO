public class Pessoaa {
    private String nome;
    private String CPF;
    private String dataaNascimento;

    public Pessoaa(
        String nome,
        String CPF,
        String dataaNascimento
    ){
        this.nome = nome;
        this.CPF = CPF;
        this.dataaNascimento = dataaNascimento;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }

    protected String getNome(){
        return this.nome;
    }

    protected void setCPF(String CPF){
        this.CPF = CPF;
    }

    protected String getCPF(){
        return this.CPF;
    }

    protected void setdataaNascimento(String dataaNascimento){
        this.dataaNascimento = dataaNascimento;
    }

    protected String getdataaNascimento(){
        return this.dataaNascimento;
    }
}
