// Importando as bibliotecas padrões e as packages.
package model;
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
    
    


    public Receita(String idReceita2, String nomeReceita2, String etapas2, int numeroEtapas2, String valor2,
            String nome) {
    }


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

    // Criando métodos das receitas e instanciando as mesmas
    public static Receita dadosReceitaum() throws Exception {
        Receita receitaum =new Receita("21","Pão de Mel","preparar a massa e assar",2,"R$ 5,00",Chef.getChefPS().get(0));
        return receitaum;
    }

    public static Receita dadosReceitadois() throws Exception {
        Receita receitadois = new Receita("87","Bolo de chocolate","Separar os ingredientes,prepara-los e fazer o bolo",3,"RS 2", Chef.getChefPS().get(1));
        return receitadois;
    }

    public static Receita dadosReceitatres() throws Exception{
        Receita receitatres = new Receita("65","Pão Francês","preparar a massa e assar",2," R$ 6,50 Kg",Chef.getChefPS().get(2));
        return receitatres;
    }

    public static Receita dadosReceitaquatro() throws Exception {
        Receita receitaquatro =  new Receita("32","Torta de Coco com chocolate","Separar os ingredientes,prepara-los e fazer a torta",3," R$ 15",Chef.getChefPS().get(0));
        return receitaquatro;
    }

    public static Receita dadosReceitacinco() throws Exception {
        Receita receitacinco = new Receita("41","Chineque convencional","preparar a massa e assar",2,"R$ 2",Chef.getChefPS().get(1));
        return  receitacinco;
    }

    public static Receita dadosReceitaseis() throws Exception{
        Receita receitaseis = new Receita("04","Orelha de gato","Separar todos os ingredientes,preparar a massa e assar",3," R$ 3",Chef.getChefPS().get(2));
        return receitaseis;
    }
    
    public static Receita dadosReceitasete() throws Exception {
        Receita receitasete = new Receita("45","Torta de Limão","Separar os ingredientes,prepara-los e fazer o bolo",3,"R$ 12",Chef.getChefPS().get(0));
        return receitasete;
    }

    public static Receita dadosReceitaoito() throws Exception {
        Receita receitaoito = new Receita("5","Coxinha de frango","Separar os ingredientes,prepara-los e fazer a coxinha",3,"R$ 3",Chef.getChefPS().get(1));
        return receitaoito;
    }

    public static Receita dadosReceitanove() throws Exception{
        Receita receitanove = new Receita("8","Bananada","Separar os ingredientes,prepara-los, assar a massa e jogar açucar em cima da massa pronta",4,"R$ 3",Chef.getChefPS().get(2));
        return receitanove;
    }

    public static Receita dadosReceitadez() throws Exception{
        Receita receitadez =new Receita("43","Coxinha de carne","Separar os ingredientes,prepara-los e fazer a coxinha",3," R$ 3",Chef.getChefPS().get(0));
        return receitadez;
    }
    
}
