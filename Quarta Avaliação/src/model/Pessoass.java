package model;

// Importandos biblioteca padrão.
import java.util.Objects;

//Criando a classe Pai Pessoass
public class Pessoass{
    // Encapsulando os atributos
    private String nome;
    private String cpf;
    protected String dataNascimento;

    // Criando o construtor da classe Pessoass
    protected Pessoass(
        String nome,
        String cpf,
        String dataNascimento
    ){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object p) {
        if (p == this)
            return true;
        if (!(p instanceof Pessoass)) {
            return false;
        }
        Pessoass pessoass = (Pessoass) p;
        return Objects.equals(this.getCPF(), pessoass.getCPF());
    }

    
    @Override
    public String toString() {
        return   "Nome:" 
            + getNome() + " / " + "CPF:"
            + getCPF() + " / " + "Data de Nascimento:" 
            + getDataNascimento(); 
    }
}

