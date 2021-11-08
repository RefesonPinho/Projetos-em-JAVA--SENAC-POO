public class Banco {

    public static void main(String[] args) {


        // Instanciando as contas correntes
        Corrente correnteum = new Corrente("2145", "4541262", "R$ 786", "14/07/2014");
        Corrente correntedois = new Corrente("1478", "12365487", "R$ 541", "04/05/2017");
        Corrente correntetres = new Corrente("4726", "9876543", "R$ 2007", "18/01/2021");
        Corrente correntequatro = new Corrente("7841", "3216547", "R$ 50000", "07/07/2007");
        Corrente correntecinco = new Corrente("1234", "8746321", "R$ 4500", "03/05/2001");
        Corrente correnteseis = new Corrente("6632", "756213", "R$ 1500", "01/11/2006");
        Corrente correntesete = new Corrente("8746127", "1112223", "R$ 900", "09/09/2009");
        Corrente correnteoito = new Corrente("2227784", "8887456", "R$ 700", "11/11/2011");
        Corrente correntenove = new Corrente("4478", "6631422", "R$ 1450", "02/03/2012");
        Corrente correntedez = new Corrente("6874", "5554123", "R$ 870", "01/07/2020");
        Corrente correnteonze = new Corrente("1114", "7784123", "R$ 3500", "15/06/2021");
        Corrente correntedoze = new Corrente("1477", "8884123", "R$ 5050", "14/04/2006");
        Corrente correntetreze = new Corrente("3214", "5412421", "R$ 6500", "02/04/2001");
        Corrente correntecatorze = new Corrente("7741", "3322112", "R$ 2500", "08/12/2005");
        Corrente correntequinze = new Corrente("2232", "9996637", "R$ 800", "09/09/1999");
        Corrente correntedezesseis = new Corrente("3321", "5554561", "R$ 600", "10/10/2011");


        // Instanciando os investimentos
        Investimento investimentoum = new Investimento("7410", "1472586", "R$ 850", "02/01/2020");
        Investimento investimentodois = new Investimento("7423", "7896541", "R$ 547", "02/03/2017");
        Investimento investimentotres = new Investimento("3214", "2648963", "R$ 20000", "15/02/2015");
        Investimento investimentoquatro = new Investimento("6987", "2649871", "R$ 1300", "01/01/2007");
        Investimento investimentocinco = new Investimento("8641", "74016521", "R$ 11000", "02/01/2014");
        Investimento investimentoseis = new Investimento("7423", "7896541", "R$ 5557", "01/01/2016");
        Investimento investimentosete = new Investimento("3214", "2648963", "R$ 3000", "11/01/2013");
        Investimento investimentoito = new Investimento("1234", "2124123", "R$ 1000", "03/03/2001");
        Investimento investimentonove = new Investimento("4126", "6669987", "R$ 950", "08/02/2020");
        Investimento investimentodez = new Investimento("0112", "3322142", "R$ 487", "02/06/2016");
        Investimento investimentoonze = new Investimento("0231", "0478125", "R$ 3500", "17/07/2015");
        Investimento investimentodoze = new Investimento("0678", "0478121", "R$ 1350", "01/08/2008");
        Investimento investimentotreze = new Investimento("0974", "6231423", "R$ 1478", "07/05/2014");
        Investimento investimentocatorze = new Investimento("0423", "0786314", "R$ 6500", "03/07/2016");
        Investimento investimentoquinze = new Investimento("0387", "4561237", "R$ 3080", "15/05/2013");
        Investimento investimentoitodezesseis = new Investimento("6987", "2649871", "R$ 1000", "05/05/2005");


        // Instanciando os Correntistas já com uma conta e um investimento que cada um possui.
        Correntista correntistaum = new Correntista("Kauê Almeida","630.380.463-29","05/01/1945","12/07/2005", correnteum,investimentoum);
        Correntista correntistadois = new Correntista("Shane Hodges","630.380.463-29459-95-0751","17/01/1931","10/05/2010", correntedois, investimentodois);
        Correntista correntistatres = new Correntista("Max Colucci","381-19-1879","05/01/1945","05/02/2001", correntetres, investimentotres);
        Correntista correntistaquatro = new Correntista("Diane Garcia","575-12-0251","19/01/1948","12/07/1980", correntequatro, investimentoquatro);
        
        
        // Instanciando os Gerentes já com uma conta e um investimento que cada um possui.
        Gerente gerenteum = new Gerente("Júlia Lima","420.671.230-17", "14/10/2005","Gerente geral", correntenove, investimentonove);
        Gerente gerentedois = new Gerente("Patrice Bohanon","513-17-8774", "27/08/1990","Gerente comercial", correntedez, investimentodez);
        Gerente gerentetres = new Gerente("Albert Fraga","252-45-7856", "07/02/1995","Gerente setorial", correnteonze, investimentoonze);
        Gerente gerentequatro = new Gerente("Gabriel Pereira","147.091.543-09", "13/05/1977","Gerente Internacional", correntedoze, investimentodoze);
    

        // Adicionando mais contas e investimentos aos Correntistas
        
        //  Correntista 1
        correntistaum.setCorrente(correnteoito);
        correntistaum.setInvestimento(investimentocinco);
        
        //  Correntista 2
        correntistadois.setCorrente(correntesete);
        correntistadois.setInvestimento(investimentoseis);

        //  Correntista 3
        correntistatres.setCorrente(correnteseis);
        correntistatres.setInvestimento(investimentosete);
        
        //  Correntista 4
        correntistaquatro.setCorrente(correntecinco);
        correntistaquatro.setInvestimento(investimentoito);

        // Adicionando mais contas e investimentos aos Gerentes
        
        // Gerente 1
        gerenteum.setCorrente(correntetreze);
        gerenteum.setInvestimento(investimentotreze);
        
        // Gerente 2 
        gerentedois.setCorrente(correntecatorze);
        gerentedois.setInvestimento(investimentocatorze);
        
        // Gerente 3
        gerentetres.setCorrente(correntequinze);
        gerentetres.setInvestimento(investimentoquinze);

        // Gerente 4
        gerentequatro.setCorrente(correntedezesseis);
        gerentequatro.setInvestimento(investimentoitodezesseis);

        // Dados do(a) Gerente 1
        System.out.println("Os dados do(a) primeiro(a) gerente é:");
        System.out.println(gerenteum.toString());
        // Contas corrente que o(a) gerente possui
        System.out.println("As contas correntes que o(a) gerente " + gerenteum.getNome() + " possui e demais dados são:");
        System.out.println(gerenteum.correntes.toString());
        // Contas  que o(a) gerente possui
        System.out.println("As contas de investimento que o(a) " + gerenteum.getNome() + " possui também e demais dados são:");
        System.out.println(gerenteum.investimentos.toString());
        

        System.out.println("\n");
        // Dados do(a) Gerente 2
        System.out.println("Os dados do(a) segundo(a) gerente é:");
        System.out.println(gerentedois.toString());
        // Contas corrente que o(a) gerente possui
        System.out.println("As contas correntes que o(a) gerente " + gerentedois.getNome() + " possui e demais dados são:");
        System.out.println(gerentedois.correntes.toString());
        // Contas  que o(a) gerente possui
        System.out.println("As contas de investimento que o(a) " + gerentedois.getNome() + " possui também e demais dados são:");
        System.out.println(gerentedois.investimentos.toString());
        

        System.out.println("\n");
        // Dados do(a) Gerente 3
        System.out.println("Os dados do(a) terceiro(a) gerente é:");
        System.out.println(gerentetres.toString());
        // Contas corrente que o(a) gerente possui
        System.out.println("As contas correntes que o(a) gerente " + gerentetres.getNome() + " possui e demais dados são:");
        System.out.println(gerentetres.correntes.toString());
        // Contas  que o(a) gerente possui
        System.out.println("As contas de investimento que o(a) " + gerentetres.getNome() + " possui também e demais dados são:");
        System.out.println(gerentetres.investimentos.toString());
        
        
        System.out.println("\n");
        // Dados do(a) Gerente 4
        System.out.println("Os dados do(a) quarto(a) gerente é:");
        System.out.println(gerentequatro.toString());
        // Contas corrente que o(a) gerente possui
        System.out.println("As contas correntes que o(a) gerente " + gerentequatro.getNome() + " possui e demais dados são:");
        System.out.println(gerentequatro.correntes.toString());
        // Contas  que o(a) gerente possui
        System.out.println("As contas de investimento que o(a) " + gerentequatro.getNome() + " possui também e demais dados são:");
        System.out.println(gerentequatro.investimentos.toString());  

        
        System.out.println("\n");
        // Dados do(a) Correntista 1
        System.out.println("Os dados do(a) primeiro(a) correntista é:");
        System.out.println(correntistaum.toString());
        // Contas corrente que o(a) Correntista possui
        System.out.println("As contas correntes que o(a) correntista " + correntistaum.getNome() + " possui e demais dados são:");
        System.out.println(correntistaum.correntes.toString());
        // Contas de investimentos que o(a) Correntista possui
        System.out.println("As contas de investimento que o(a)  " + correntistaum.getNome() + " possui também e demais dados são:");
        System.out.println(correntistaum.investimentos.toString());
        

        System.out.println("\n");
        // Dados do(a) Correntista 2
        System.out.println("Os dados do(a) segundo(a) correntista é:");
        System.out.println(correntistadois.toString());
        // Contas corrente que o(a) Correntista possui
        System.out.println("As contas correntes que o(a) correntista " + correntistadois.getNome() + " possui e demais dados são:");
        System.out.println(correntistadois.correntes.toString());
        // Contas de investimentos que o(a) Correntista possui
        System.out.println("As contas de investimento que o(a) " + correntistadois.getNome() + " possui também e demais dados são:");
        System.out.println(correntistadois.investimentos.toString());

        System.out.println("\n");
        // Dados do(a) Correntista 3
        System.out.println("Os dados do(a) primeiro(a) correntista é:");
        System.out.println(correntistatres.toString());
        // Contas corrente que o(a) Correntista possui
        System.out.println("As contas correntes que o(a) correntista " + correntistatres.getNome() + " possui e demais dados são:");
        System.out.println(correntistatres.correntes.toString());
        // Contas de investimentos que o(a) Correntista possui
        System.out.println("As contas de investimento que o(a) " + correntistatres.getNome() + " possui também e demais dados são:");
        System.out.println(correntistatres.investimentos.toString());
        
        
        System.out.println("\n");
        // Dados do(a) Correntista 4
        System.out.println("Os dados do(a) quarto(a) correntista é:");
        System.out.println(correntistaquatro.toString());
        // Contas corrente que o(a) correntista possui
        System.out.println("As contas correntes que o(a) correntista " + correntistaquatro.getNome() + " possui e demais dados são:");
        System.out.println(correntistaquatro.correntes.toString());
        // Contas  que o(a) correntista possui
        System.out.println("As contas de investimento que o(a) " + correntistaquatro.getNome() + " possui também e demais dados são:");
        System.out.println(correntistaquatro.investimentos.toString());       
    }
}
    
    

    

    



   


    

    

    
    
    
    





