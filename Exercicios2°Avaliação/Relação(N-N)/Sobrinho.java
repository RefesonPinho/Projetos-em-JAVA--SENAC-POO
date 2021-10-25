import java.util.ArrayList;

public class Sobrinho {
    
    String nome;
    String apelido;
    ArrayList<Tio> tios = new ArrayList<>();

    public Sobrinho(
        String nome,
        String apelido
    ) {
        this.nome = nome;
        this.apelido = apelido;
    }

    public void adicionarTio(Tio tio) {
        this.tios.add(tio);
    }
}
