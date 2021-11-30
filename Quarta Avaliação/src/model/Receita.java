package model;

// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;

// Criando a classe Receita e seus atributos
public class Receita {
    
    // Encapsulando os atributos e criando collections com ArrayLists através do relacionamento de classes
    
    private String idReceita;
    private String nomeReceita;
    private String etapas;
    private int numeroEtapas; 
    private String valor;
    private Chef chef;
    private ArrayList <Padaria> padarias = new ArrayList<>();
    private ArrayList <Cliente> clientes = new ArrayList<>();
    private ArrayList <Mercados> supermercados = new ArrayList<>();
    
    
    // Criando o construtor da classe Receita
   
    public Receita(
        String idReceita,
        String nomeReceita,
        String etapas,
        int numeroEtapas,
        String valor,
        Chef chef
    ){
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.etapas = etapas;
        this.numeroEtapas = numeroEtapas;
        this.valor = valor;
        this.chef = chef;        
    }


    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    
    public void setIdReceita(String idReceita){
        this.idReceita = idReceita;
    }

    public String getIdReceita(){
        return this.idReceita;
    }

    public void setNomeReceita(String nomeReceita){
        this.nomeReceita = nomeReceita;
    }

    public String getNomeReceita(){
        return this.nomeReceita;
    }

    public void setEtapas( String etapas){
        this.etapas = etapas;
    }

    public String getEtapas(){
        return this.etapas;
    }

    public void setNumeroEtapa(int numeroEtapas){
        this.numeroEtapas =numeroEtapas;
    }

    public int getNumeroEtapas(){
        return this.numeroEtapas;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }

    public void setChef(Chef chef){
        this.chef = chef;
    }

    public Chef getChef(){
        return this.chef;
    }

    public void setPadaria( Padaria padaria){
        this.padarias.add(padaria);
             
    }

    public ArrayList<Padaria> getPadaria(){
        return this.padarias;
        
    }

    public void setClientes( Cliente cliente){
        this.clientes.add(cliente);    
    }

    public ArrayList<Cliente> getCliente(){
        return this.clientes;
    }

    public void setMercados( Mercados mercados){
        this.supermercados.add(mercados);     
    }

    public ArrayList<Mercados> getMercados(){
        return this.supermercados;
    }

    // Fazendo uso do padrão de projeto Decorator 

    @Override
    public boolean equals(Object r) {
        if (r == this)
            return true;
        if (!(r instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) r;
        return Objects.equals(this.getIdReceita(), receita.getIdReceita());
    }

    @Override
    public String toString() {
        return   "Receita: " 
            + getNomeReceita() + " / " + "Chef:"
            + getChef().getNome() + " / " + "Id:"
            + getIdReceita() + " / " + "Etapas:" 
            + getEtapas() + " / " + "Numero de Etapas:" 
            + getNumeroEtapas() + " / " + "Valor:"
            + getValor();
    }

    public String dadosReceita(){
        return "Receita: " 
        + getNomeReceita()  + " / " + "Chef:"  
        + getChef().getNome()  + " / " + "id:" 
        + getIdReceita()  + " / " + "Número de etapas:"
        + getNumeroEtapas()  + " / " + "Etapas:" 
        + getEtapas()  + " / " + "Valor:" 
        + getValor();
    }
}
