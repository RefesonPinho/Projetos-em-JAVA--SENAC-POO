
// Importando a package
package src.model;

import java.util.Objects;

// Criando a classe Jaula
public class Jaula {
    private int idJaula;
    private String descricao;
    // Criando as classes construtora de Jaula fazendo uso do POLIMORFISMO
    public Jaula(
        int idJaula,
        String descricao
    ){
        this.idJaula = idJaula;
        this.descricao = descricao;
    }

    public Jaula(
        int idJaula
    ){
        this.idJaula = idJaula;
    }

    public Jaula(
        String descricao
    ){
        this.descricao = descricao;
    }
    
    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(int idJaula) {
        this.idJaula = idJaula;
    }

    public Jaula IdJaula(int idJaula) {
        setIdJaula(idJaula);
        return this;
    }

    public Jaula descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

     // Fazendo uso do padrão de projeto Decorator 
     @Override
     public boolean equals(Object j) {
         if (j == this)
             return true;
         if (!(j instanceof Jaula)) {
             return false;
         }
         Jaula jaula = (Jaula) j;
         return Objects.equals(this.getIdJaula(), jaula.getIdJaula());
     }
 
     @Override
     public String toString() {
         return   "Id da Jaula :" 
             + getIdJaula() + " / " + "Descricão:"
             + getDescricao();
     }
}
