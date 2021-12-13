// Importando as bibliotecas padrões e as packages.
package src.model;
import java.util.Objects;
//Criando a classe Pai Animal
public class Animal {
    private int id;
    private String nome;
    // Criando as classes construtora de Animal fazendo uso do POLIMORFISMO
    protected Animal(
        int id,
        String nome
    ){
        this.id = id;
        this.nome = nome;
    }

    protected Animal(
        String nome
    ){
        this.nome = nome;
    }

    protected Animal(
        int id
    ){
        this.id = id;  
    }
 
    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAnimal() {
        return id;
    }

    public void setIdAnimal(int id) {
        this.id = id;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object a) {
        if (a == this)
            return true;
        if (!(a instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) a;
        return Objects.equals(this.getIdAnimal(), animal.getIdAnimal());
    }

    @Override
    public String toString() {
        return   "Id :" 
            + getIdAnimal() + " / " + "Nome:"
            + getNome();
    }
}
