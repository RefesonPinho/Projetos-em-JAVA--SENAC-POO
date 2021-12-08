package model;

import java.util.Objects;

public class Animal {
    protected int id;
    protected String nome;

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

    public void setIdAnimal(int id){
        this.id = id;
    }

    public int getIdAnimal(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
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
        return   "IdAnimal:" 
            + getIdAnimal() + " / " + "nome:"
            + getNome() ;
    }
}
