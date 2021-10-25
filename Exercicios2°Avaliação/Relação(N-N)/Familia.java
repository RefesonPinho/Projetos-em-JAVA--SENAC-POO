public class Familia {
    public static void main(String[] args) {
        Tio tioUm = new Tio("Marcos","Sinuca","Cola no Tio aqui que Você cresce");
        Tio tioDois = new Tio("Joaquina","Falar mau dos Outros","Aqui caiu na rede é peixe");
        Tio tioTres = new Tio("Augusto", "Andar de Bicicleta", "A vidá é um pé de manga,um dia Você manga de mim outro dia Eu mango de Você");

        Sobrinho sobrinhoUm = new Sobrinho("Fabio","Fa");
        Sobrinho sobrinhoDois = new Sobrinho("Fernanda", "Nandinha");

        tioUm.adicionarSobrinho(sobrinhoUm);
        tioTres.adicionarSobrinho(sobrinhoUm);

        tioUm.adicionarSobrinho(sobrinhoDois);
        tioDois.adicionarSobrinho(sobrinhoDois);

        System.out.println("Sobrinhos(as) do(a) Tio(a) " + tioUm.nome);
        for (Sobrinho sobrinho : tioUm.sobrinhos) {
            System.out.println(sobrinho.nome);
        }
        System.out.println("\n");
        System.out.println("Sobrinhos(as) do(a) Tio(a) " + tioDois.nome);
        for (Sobrinho sobrinho : tioDois.sobrinhos) {
            System.out.println(sobrinho.nome);
        }
        System.out.println("\n");
        System.out.println("Sobrinhos(as) do(a) Tio(a) " + tioTres.nome);
        for (Sobrinho sobrinho : tioTres.sobrinhos) {
            System.out.println(sobrinho.nome);
        }

        System.out.println("\n");
        System.out.println("Tios(as) do(a) Sobrinho(a) " +sobrinhoUm.nome+ " e sua(as) piadas:");
        for (Tio tio : sobrinhoUm.tios) {
            System.out.println(tio.nome + " - " + tio.piadaPronta);
        }
        System.out.println("\n");
        System.out.println("Tios(as) do(a) Sobrinho(a) " +sobrinhoDois.nome+ " e sua(as) piadas:");
        for (Tio tio : sobrinhoDois.tios) {
            System.out.println(tio.nome + " - " + tio.piadaPronta);
        }
    }
}
