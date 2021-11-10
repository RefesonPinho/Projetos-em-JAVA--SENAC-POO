import java.util.ArrayList;
import java.util.Objects;

public class Receita {
    private String idReceita;
    private String nomeReceita;
    private String etapas;
    private int numeroEtapas; 
    private String valor;
    private Chef chef;
    private ArrayList <Padaria> padarias = new ArrayList<>();
    private ArrayList <Cliente> clientes = new ArrayList<>();
    private ArrayList <Mercados> supermercados = new ArrayList<>();
    

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
        return   "Id da Receita:" 
            + getIdReceita() + " / " + "Nome da Receita:"
            + getNomeReceita() + " / " + "Etapas:" 
            + getEtapas() + " / " + "Numero de Etapas:" 
            + getNumeroEtapas() + " / " + "Valor:"
            + getValor() + " / " + "Chef:"
            + getChef() + " / " + "Supermercados:"  
            + getMercados() + " / " + "Padaria:"
            + getMercados() + " / " + "clientes:"
            + getCliente();
    }

    public String dadosReceita(){
        return "Nome :" + getNomeReceita();
    }
}
