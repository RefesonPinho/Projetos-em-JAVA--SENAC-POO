//Criando a classe Pai Pessoaa
public class Pessoaa {
    // Encapsulando os atributos
    private String nome;
    private String CPF;
    private String dataaNascimento;

    // Criando o construtor da classe Pessoaa
    public Pessoaa(
        String nome,
        String CPF,
        String dataaNascimento
    ){
        this.nome = nome;
        this.CPF = CPF;
        this.dataaNascimento = dataaNascimento;
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
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
