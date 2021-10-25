import java.util.ArrayList;

public class Tio {
    
    String nome;
    String vicio;
    String piadaPronta;
    ArrayList<Sobrinho> sobrinhos = new ArrayList<>();

    public Tio(
        String nome,
        String vicio,
        String piadaPronta
    ){
        this.nome = nome;
        this.vicio = vicio;
        this.piadaPronta = piadaPronta;
    }
    
    public void adicionarSobrinho(Sobrinho sobrinho) {
        this.sobrinhos.add(sobrinho);
        sobrinho.adicionarTio(this);
    }

}
