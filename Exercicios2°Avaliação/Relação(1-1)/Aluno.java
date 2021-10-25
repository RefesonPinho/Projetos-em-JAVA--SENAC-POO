public class Aluno {
    
    String nome;
    String telefone;
    String curso;
    int periodo;
    int matricula;
    String tipoSanguineo;
    Endereco endereco;
    String nascimento;
    Cracha cracha;

    public Aluno(
        String nome,
        String telefone,
        String curso,
        int periodo,
        int matricula,
        String tipoSanguineo,
        String nascimento,
        String rua,
        String cep,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String pais,
        String foto,
        String instituicao,
        String dataInicial
    ) {
        this.nome = nome;
        this.telefone = telefone;
        this.curso = curso;
        this.periodo = periodo;
        this.matricula = matricula;
        this.tipoSanguineo = tipoSanguineo;
        this.endereco = new Endereco(cep,rua,numero,bairro,cidade, estado,pais);
        this.nascimento = nascimento;
        this.cracha = new Cracha( numero,foto,instituicao,dataInicial,this );
    }

}
