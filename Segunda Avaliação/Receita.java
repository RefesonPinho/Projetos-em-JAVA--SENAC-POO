import java.util.ArrayList;

public class Receita {

    private String idReceita;
    private String nomeReceita;
    private String etapas;
    private int numeroetapas;
    private int valor; 
    private Chef chef;
    private ArrayList <Padaria> padaria = new ArrayList<>();
    private ArrayList <Cliente> clientes = new ArrayList<>();
    

    public Receita(

        String idReceita,
        String nomeReceita,
        String etapas,
        int numeroetapas,
        int valor,
        String idChefe,
        String nome,
        String cpf,
        String dataNascimento,
        String especialidade
    ){
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.etapas = etapas;
        this.numeroetapas = numeroetapas;
        this.numeroetapas = numeroetapas;
        this.chef = new Chef(nome, cpf, dataNascimento, idChefe, especialidade);
    }

    public void setidReceita(String idReceita){
        this.idReceita = idReceita;
    }

    public String getidReceita(){
        return this.idReceita;
    }

    public void setnomeReceita(String nomeReceita){
        this.nomeReceita = nomeReceita;
    }

    public String getReceita(){
        return this.nomeReceita;
    }

    public void setEtapas(String etapas){
        this.etapas = etapas;
    }

    public String getEtapas(){
        return this.etapas;
    }

    public void setNumeroEtapas(int numeroetapas){
        this.numeroetapas = numeroetapas;
    }

    public int getNumeroEtapas(){
        return this.numeroetapas;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return this.valor;
    }

    public void setChef(Chef chef){
        this.chef = chef;
    }

    public Chef getChef(){
        return this.chef;
    }
        
    public void setPadaria(Padaria padaria){
        this.padaria.add(padaria);   
    }

    public ArrayList<Padaria> getPadaria(){
        return this.padaria;
    } 

    public void setCliente(Cliente cliente){
        this.clientes.add(cliente);  
    }

    public ArrayList<Cliente> getcliente(){
        return this.clientes;
    } 
}

