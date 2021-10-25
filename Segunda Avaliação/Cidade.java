public class Cidade {

   
    public static void main(String[] args){

        Chef chefum = new Chef("1","Guilherme Silva","074.258.321","04/05/2000");
        Chef chefdois = new Chef("2","Maria Santos","365.487.874","06/04/2002");
        Chef cheftres = new Chef("3","Matheus Pontes","865.756.254","08/01/1999");

        Receita pratoum = new Receita("21","Pão de Mel","preparar a massa e assar",2,"1","Guilherme Silva","074.258.321","04/05/2000");
        Receita pratodois = new Receita("87","Bolo de chocolate","Separar os ingredientes,prepara-los e fazer o bolo",3,"2","Maria Santos","365.487.874","06/04/2002");
        Receita pratotres = new Receita("65","Pão Francês","preparar a massa e assar",2,"3","Matheus Pontes","865.756.254","08/01/1999");
        Receita pratoquatro = new Receita("32","Torta de Coco com chocolate","Separar os ingredientes,prepara-los e fazer a torta",3,"1","Guilherme Silva","074.258.321","04/05/2000");
        Receita pratocinco = new Receita("41","Chineque convencional","preparar a massa e assar",2,"2","Maria Santos","365.487.874","06/04/2002");
        Receita pratoseis = new Receita("04","Orelha de gato","Separar todos os ingredientes,preparar a massa e assar",3,"3","Matheus Pontes","865.756.254","08/01/1999");
        Receita pratosete = new Receita("45","Torta de Limão","Separar os ingredientes,prepara-los e fazer o bolo",3,"1","Guilherme Silva","074.258.321","04/05/2000");
        Receita pratooito = new Receita("5","Coxinha de frango","Separar os ingredientes,prepara-los e fazer a coxinha",3,"2","Maria Santos","365.487.874","06/04/2002");
        Receita pratonove = new Receita("8","Bananada","Separar os ingredientes,prepara-los, assar a massa e jogar açucar em cima da massa pronta",4,"3","Matheus Pontes","865.756.254","08/01/1999");

        Padaria padariaum = new Padaria("56","Padaria do Ze","05/08/1995","83","78141-562","Rua dos Jornalistas",74,"Petropolis","Joinville");
        Padaria padariadois = new Padaria("21","Padaria do seu Bartolomeu","01/02/1990","12","124564-789","Rua XV de Novembro",47,"Centro","Joinville");
        Padaria padariatres = new Padaria("1","Padaria da Francisca","25/04/2004","74","456741-123","Rua Waldemiro José Borges", 798,"Profipo","Joinville");


        padariaum.adicionarReceita(pratoum);
        padariaum.adicionarReceita(pratonove);
        padariaum.adicionarReceita(pratocinco);
        padariaum.adicionarReceita(pratodois);
        padariaum.adicionarReceita(pratosete);


        padariadois.adicionarReceita(pratoquatro);
        padariadois.adicionarReceita(pratooito);
        padariadois.adicionarReceita(pratotres);
        padariadois.adicionarReceita(pratodois);
        padariadois.adicionarReceita(pratocinco);

        padariatres.adicionarReceita(pratoseis);
        padariatres.adicionarReceita(pratonove);
        padariatres.adicionarReceita(pratoquatro);
        padariatres.adicionarReceita(pratosete);
        padariatres.adicionarReceita(pratodois);


        chefum.adicionarReceita(pratoum);
        chefum.adicionarReceita(pratocinco);
        chefum.adicionarReceita(pratosete);



        chefdois.adicionarReceita(pratooito);
        chefdois.adicionarReceita(pratonove);
        chefdois.adicionarReceita(pratodois);

        

        cheftres.adicionarReceita(pratoquatro);
        cheftres.adicionarReceita(pratotres);
        cheftres.adicionarReceita(pratocinco);


    
        System.out.println("Cardápio  da "+ padariaum.nome + " e seus Chefes:");
        for (Receita receita : padariaum.pratos){
            System.out.println("\nNome da receita\n"
            + receita.nomereceita + "\nNome do(a) Chefe\n"
            + receita.chef.nome ); 
        }

        System.out.println("\n");
        System.out.println("Cardápio  da "+ padariadois.nome + " e seus Chefes:");
        for(Receita receita : padariadois.pratos){
            System.out.println("\nNome da receita\n"
            + receita.nomereceita + "\nNome do(a) Chefe\n"
            + receita.chef.nome );  
        }

        System.out.println("\n");
        System.out.println("Cardápio  da "+ padariatres.nome + " e seus Chefes:");
        for(Receita receita : padariatres.pratos){
            System.out.println("\nNome da receita\n"
            + receita.nomereceita + "\nNome do(a) Chefe\n"
            + receita.chef.nome ); 
        }



        System.out.println("\n");
        System.out.println("Conheça um pouco mais do perfil dos Chefes :");
        System.out.println("Primeiro(a) Chefe:");
        System.out.println("Idchef \n"
        + chefum.idchefe+"\nNome\n" 
        + chefum.nome+"\nCPF\n" 
        + chefum.cpf+"\nData de nascimento\n" 
        + chefum.datanascimento );

     
        
        System.out.println("\n");
        System.out.println("O(a) Chefe " + chefum.nome + " tem as seguintes receitas:");
        for(Receita receita : chefum.receitas){
            System.out.println(receita.nomereceita);
        }
     

        System.out.println("\n");
        System.out.println("Proximo(a) Chefe:");
        System.out.println("Idchefe \n"
        + chefdois.idchefe+"\nNome \n" 
        + chefdois.nome+"\nCPF \n" 
        + chefdois.cpf+"\nData de nascimento\n" 
        + chefdois.datanascimento );


        System.out.println("\n");
        System.out.println("O(a) Chefe " + chefdois.nome + " tem as seguintes receitas:");
        for(Receita receita : chefdois.receitas){
            System.out.println(receita.nomereceita);
        }


        System.out.println("\n");
        System.out.println("Proximo(a) Chefe:");
        System.out.println("Idchefe \n"
        + cheftres.idchefe+"\nNome \n" 
        + cheftres.nome+"\nCPF \n" 
        + cheftres.cpf+"\nData de nascimento\n" 
        + cheftres.datanascimento );


        System.out.println("\n");
        System.out.println("O(a) Chefe " + cheftres.nome + " tem as seguintes receitas:");
        for(Receita receita : cheftres.receitas){
            System.out.println(receita.nomereceita);
        }


        System.out.println("\n");
        System.out.println("Os dados da " + padariaum.nome + " é:" );
        System.out.println("Id\n" 
        + padariaum.id  + "\nData de abertura\n"
        + padariaum.datadeabertura + "\nIdEndereço\n"
        + padariaum.endereco.id + "\nCidade\n"
        + padariaum.endereco.cidade + "\nBairro\n"
        + padariaum.endereco.bairro +"\nCep\n"
        + padariaum.endereco.cep + "\nRua\n"
        + padariaum.endereco.rua + "\nNumero\n"
        + padariaum.endereco.numero );



        System.out.println("\n");
        System.out.println("Os dados da " + padariadois.nome + " é:" );
        System.out.println("Id\n" 
        + padariadois.id  + "\nData de abertura\n"
        + padariadois.datadeabertura + "\nIdEndereço\n"
        + padariadois.endereco.id + "\nCidade\n"
        + padariadois.endereco.cidade + "\nBairro\n"
        + padariadois.endereco.bairro +"\nCep\n"
        + padariadois.endereco.cep + "\nRua\n"
        + padariadois.endereco.rua + "\nNumero\n"
        + padariadois.endereco.numero );



        System.out.println("\n");
        System.out.println("Os dados da " + padariatres.nome + " é:" );
        System.out.println("Id\n" 
        + padariatres.id  + "\nData de abertura\n"
        + padariatres.datadeabertura + "\nIdEndereço\n"
        + padariatres.endereco.id + "\nCidade\n"
        + padariatres.endereco.cidade + "\nBairro\n"
        + padariatres.endereco.bairro +"\nCep\n"
        + padariatres.endereco.cep + "\nRua\n"
        + padariatres.endereco.rua + "\nNumero\n"
        + padariatres.endereco.numero );
    }   
}
