// Criando a classe Cidade como programa Principal
public class Cidade {
    public static void main(String[] args) {
        //Instanciando os Clientes no sistema
        Cliente clienteum = new Cliente("Kelvin Ray", "571-21-8951", "27/10/2001", "(47) 2514-5227");
        Cliente clientdois = new Cliente("Júlio Martins", "168.030.656-18", "13/08/2009", "(67) 6037-6726");
        Cliente clientetres = new Cliente("Murilo Rodrigues", "465.494.817-16", "14/06/1992", "(21) 3666-8319");

        //Instanciando os Chefs no sistema
        Chef chefum = new Chef("Guilherme Silva", "074.258.321", "04/05/2000", "21", "Padeiro");
        Chef chefdois = new Chef("Maria Santos","365.487.874","06/04/2002","45","Doceteiro");
        Chef cheftres = new Chef("Matheus Pontes","865.756.254","08/01/1999","64","Padeiro");

        //Instanciando as Padarias no sistema
        Padaria padariaum = new Padaria("56","Padaria do Ze","05/08/1995", "Joinville","Petropolis","78141-562","Rua dos Jornalistas", 74, "Das 6 as 20h");
        Padaria padariadois = new Padaria("21","Padaria do seu Bartolomeu","01/02/1990", "Joinville","Profipo","456741-123","Rua Waldemiro José Borges",798, "Das 6 as 20h");
        Padaria padariatres = new Padaria("1","Padaria da Francisca","25/04/2004", "Joinville","Centro","124564-789","Rua XV de Novembro",47, "Das 6 as 20h");

        //Instanciando os Mercados no sistema
        Mercados mercadoum = new Mercados("142","Mercado  Silva","03/07/2014", "Joinville","Floresta","223698-74","Rua dos Pardais", 124, "Comproum duas peças de cada item leva uma 0800");
        Mercados mercadodois = new Mercados("748","Mercado da Mônica","25/04/2010", "Joinville","Costa e Silva","147896-14","Rua das Flores", 478, "Dia dos salgados e doces por metade do preço");
        Mercados mercadotres = new Mercados("142","Mercado do Povo","03/07/2014", "Joinville","Centro","223698-74","Rua das Pedras", 791, "A cada dez peças compradas leva 5");

        
        //Instanciando as Receitas com seus determinados Chefs no sistema
        Receita pratoum = new Receita("21","Pão de Mel","preparar a massa e assar",2,"R$ 5,00", chefum);
        Receita pratodois = new Receita("87","Bolo de chocolate","Separar os ingredientes,prepara-los e fazer o bolo",3,"RS 2", chefdois);
        Receita pratotres = new Receita("65","Pão Francês","preparar a massa e assar",2," R$ 6,50 Kg",cheftres);
        Receita pratoquatro = new Receita("32","Torta de Coco com chocolate","Separar os ingredientes,prepara-los e fazer a torta",3," R$ 15",chefum);
        Receita pratocinco = new Receita("41","Chineque convencional","preparar a massa e assar",2,"R$ 2",chefdois);
        Receita pratoseis = new Receita("04","Orelha de gato","Separar todos os ingredientes,preparar a massa e assar",3," R$ 3",cheftres);
        Receita pratosete = new Receita("45","Torta de Limão","Separar os ingredientes,prepara-los e fazer o bolo",3,"R$ 12",chefum);
        Receita pratooito = new Receita("5","Coxinha de frango","Separar os ingredientes,prepara-los e fazer a coxinha",3,"R$ 3",chefdois);
        Receita pratonove = new Receita("8","Bananada","Separar os ingredientes,prepara-los, assar a massa e jogar açucar em cima da massa pronta",4,"R$ 3",cheftres);
        Receita pratodez = new Receita("43","Coxinha de carne","Separar os ingredientes,prepara-los e fazer a coxinha",3," R$ 3",chefum);

        // Adicionando as Receitas na Padaria 1
        padariaum.setReceita(pratocinco);
        padariaum.setReceita(pratodez);
        padariaum.setReceita(pratoseis);
        padariaum.setReceita(pratosete);
        padariaum.setReceita(pratoum);


        // Adicionando as Receitas na Padaria 2
        padariadois.setReceita(pratooito);
        padariadois.setReceita(pratonove);
        padariadois.setReceita(pratoquatro);
        padariadois.setReceita(pratotres);
        padariadois.setReceita(pratoum);


        // Adicionando as Receitas na Padaria 3
        padariatres.setReceita(pratooito);
        padariatres.setReceita(pratonove);
        padariatres.setReceita(pratoquatro);
        padariatres.setReceita(pratotres);
        padariatres.setReceita(pratoum);


        // Adicionando as Receitas no Mercado 1
        mercadoum.setReceita(pratoum);
        mercadoum.setReceita(pratodois);
        mercadoum.setReceita(pratodez);
        mercadoum.setReceita(pratosete);
        mercadoum.setReceita(pratotres);
        mercadoum.setReceita(pratocinco);

        // Adicionando as Receitas no Mercado 2
        mercadodois.setReceita(pratoum);
        mercadodois.setReceita(pratodois);
        mercadodois.setReceita(pratodez);
        mercadodois.setReceita(pratosete);
        mercadodois.setReceita(pratotres);
        mercadodois.setReceita(pratocinco);

        // Adicionando as Receitas no Mercado 3
        mercadotres.setReceita(pratoum);
        mercadotres.setReceita(pratodois);
        mercadotres.setReceita(pratodez);
        mercadotres.setReceita(pratosete);
        mercadotres.setReceita(pratotres);
        mercadotres.setReceita(pratocinco);


        // Adicionando as Receitas compradas pelo Cliente 1
        clienteum.setReceita(pratocinco);
        clienteum.setReceita(pratodez);
        clienteum.setReceita(pratoseis);
        clienteum.setReceita(pratosete);
        clienteum.setReceita(pratoum);

         
        // Adicionando as Receitas compradas pelo Cliente 2
        clientdois.setReceita(pratoum);
        clientdois.setReceita(pratocinco);
        clientdois.setReceita(pratodois);
        clientdois.setReceita(pratotres);
        clientdois.setReceita(pratoum);

        // Adicionando as Receitas compradas pelo Cliente 3
        clientetres.setReceita(pratooito);
        clientetres.setReceita(pratonove);
        clientetres.setReceita(pratoquatro);
        clientetres.setReceita(pratotres);
        clientetres.setReceita(pratodois);

       
        // Dados das padarias 1,2 e 3 usando o método toString a apartir padrão de projeto Decorator
        System.out.println(padariaum.toString());
        System.out.println(padariadois.toString());
        System.out.println(padariatres.toString());

        // Dados dos mercados 1,2 e 3 usando o método toString a apartir padrão de projeto Decorator
        System.out.println(mercadoum.toString());
        System.out.println(mercadodois.toString());
        System.out.println(mercadotres.toString());

        System.out.println("\n");
        // Dados dos Clientes 1,2 e 3 usando o método toString a apartir padrão de projeto Decorator
        System.out.println(clienteum.toString());
        System.out.println(clientdois.toString());
        System.out.println(clientetres.toString());

        System.out.println("\n");
        // Dados dos Chefs 1,2 e 3 usando o método toString a apartir padrão de projeto Decorator
        System.out.println(chefum.toString());
        System.out.println(chefdois.toString());
        System.out.println(cheftres.toString());

        System.out.println("\n");
        // Dados das receitas 1 até a 10 usando o método toString a apartir padrão de projeto Decorator
        System.out.println(pratoum.toString());
        System.out.println(pratodois.toString());
        System.out.println(pratotres.toString());
        System.out.println(pratoquatro.toString());
        System.out.println(pratocinco.toString());
        System.out.println(pratoseis.toString());
        System.out.println(pratosete.toString());
        System.out.println(pratooito.toString());
        System.out.println(pratonove.toString());
        System.out.println(pratodez.toString());  
    }
}
