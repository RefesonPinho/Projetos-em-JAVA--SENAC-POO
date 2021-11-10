import java.util.ArrayList;
import java.util.Objects;

public class Mercados extends Estabelecimento{
    private String promocao;
    private ArrayList <Receita> pratos = new ArrayList<>();


    public Mercados(
        String idAlvara,
        String nomeEstabelecimento,
        String datadeabertura,
        String cidade,
        String bairro,
        String cep,
        String rua,
        int numero,
        String promocao
        
    ){
        super(idAlvara, nomeEstabelecimento, datadeabertura, cidade, bairro, cep, rua, numero);
        this.promocao = promocao;
        
    }

    public void setPromocao(String promocao){
        this.promocao = promocao;
    }

    public String getPromocao(){
        return this.promocao;
    }

    public void setReceita(Receita receita){
        this.pratos.add(receita);
    }
    
    public ArrayList<Receita> getReceita(){
        return this.pratos;
    }

    @Override
    public boolean equals(Object m) {
        if (m == this)
            return true;
        if (!(m instanceof Mercados)) {
            return false;
        }
        Mercados mercados = (Mercados) m;
        return Objects.equals(this.getIdAlvara(), mercados.getIdAlvara());
    }

    @Override
    public String toString() {
        return   "Id do Alvará:" 
            + getIdAlvara() + " / " + "Nome do Estabelecimento:"
            + getNomeEstabelecimento() + " / " + "Data de abertura:" 
            + getDataAbertura() + " / " + "Cidade:" 
            + getEndereco().getCidade() + " / " + "Bairro:"
            + getEndereco().getBairro() + " / " + "Cep:"
            + getEndereco().getCep() + " / " + "Rua:"  
            + getEndereco().getRua() + " / " + "Número:"
            + getEndereco().getNumero() + " / " + "Promoção:"
            + getPromocao();
    }
}