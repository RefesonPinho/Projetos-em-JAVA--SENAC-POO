public class Escola {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(
            "Mathias",
            "(47) 99999-9999",
            "ADS",
            2,
            45,
            "O+",
            "01/01/1990",
            "Rua Bernado Stann",
            "89211-100",
            "123",
            "Floresta",
            "Joinville",
            "SC",
            "Brasil",
            "ftp://jws.tsc.com.br/122433",
            "Senac",
            "15/07/2019"
        );

        System.out.println("Os dados do aluno matriculado no " + aluno.cracha.instituicao + " é:");
        System.out.println("Nome do aluno\n" 
        + aluno.nome + "\nTelefone\n"
        + aluno.telefone + "\nPeriodo do curso\n"
        + aluno.periodo + "\nTipo sanguineo\n"
        + aluno.tipoSanguineo + "\nData de nascimento\n"
        + aluno.nascimento + "\nPais\n"
        + aluno.endereco.pais + "\nEstado\n"
        + aluno.endereco.estado + "\nCidade\n"
        + aluno.endereco.cidade + "\nBairro\n"
        + aluno.endereco.bairro + "\nCep\n"
        + aluno.endereco.cep + "\nRua\n"
        + aluno.endereco.rua + "\nNumero\n"
        + aluno.endereco.numero);

        System.err.println("\n");
        System.out.println("Os dados no cracha de identificação do aluno " + aluno.nome+ " é:");
        System.out.println( "Foto\n" + aluno.cracha.foto + "\nInstituição\n"
        + aluno.cracha.instituicao + "\nData inicial\n"
        + aluno.cracha.dataInicial );
    }
}
