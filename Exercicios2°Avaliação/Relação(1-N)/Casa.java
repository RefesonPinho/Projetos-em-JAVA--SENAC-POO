public class Casa {
    public static void main(String[] args) {
        Geladeira geladeira = new Geladeira("Cinza", "Consul", 2, 1, 600);

        geladeira.adicionarFruta("Banana", "Bananas Estratosféricas", "B12");
        geladeira.adicionarFruta("Manga","Manga rosa", "E");

        Fruta fruta = new Fruta("Maça", "Maça Ultrassônica", "A");

        geladeira.adicionarFruta(fruta);




        System.out.println("As caracteristicas da geladeira são:");
        System.out.println("Cor\n"
        + geladeira.cor + "\nMarca\n"
        + geladeira.marca + "\nAltura\n"
        + geladeira.altura +" metros" + "\nCapacidade\n"
        + geladeira.capacidade +" litros");


        System.out.println("\n");
        System.out.println("As frutas que contem na geladeira "+ geladeira.marca + " e suas caracteristicas são:" );
        for(Fruta frutas : geladeira.frutas){
            System.out.println("Tipo da fruta\n" 
            + frutas.tipo + "\nNome cientifico\n" 
            + frutas.nomeCientifico + "\nVitamina(as)\n" 
            + frutas.vitaminas +"\n");
        }
        System.out.println("O total de frutas que tem na geladeira é:");
        System.out.println(geladeira.frutas.size());
    

        
        


    


    

    }
}
