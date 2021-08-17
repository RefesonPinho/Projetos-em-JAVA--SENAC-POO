import java.util.Scanner;
public class ListaExercicio {
 public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      System.out.println("Ex. 1-calcule a média ((nota1 + nota2 + nota3 / 3))");
      int nota1=10;
      int nota2=10;
      int nota3=10;
      int media=(nota1+nota2+nota3) / 3;
      System.out.println(media);
      
      System.out.println("Ex. 2-calcule a área (lado1 * lado2)) ");
      double area1=5.5;
      double area2=7;
      double calculoarea= area1*area2;
      System.out.println(calculoarea); 
        
      System.out.println("Ex. 3-calcule o volume (largura * altura * profundidade) ");
      double largura=5.5;
      double altura=7;
      double profundidade=20;
      double calculovolume=largura*altura*profundidade;
      System.out.println(calculovolume); 
        
      System.out.println("Ex. 4-avalie se um valor é maior do que o dobro de outro valor  ");
      int valor1=7;
      int valor2=15;
      
      // CONDIÇÃO? VALOR SE TRUE : VALOR SE FALSE
      String message = valor2 >= (valor1 * 2)
            ?"É maior ou igual ao dobro do valor 1"
            :"Não é maior ou igual ao dobro do valor 1";
      
      System.out.println(message);   
    
    
     System.out.println("Ex. 5-calcule bhaskara ");
     
    
     System.out.println("Ex. 6-  Calcule a velocidade média de uma viagem (distancia (km) / tempo (h))  ");
      double distancia=400;
      double tempo= 4;
      double velocidademedia=distancia / tempo;
      System.out.println(velocidademedia); 
    
     System.out.println("Ex. 7-  calcule o percentual de imposto pago (faturamento / qtd imposto)   ");
     System.out.println("Digite o valor do faturamento: ");
      double faturamento= s.nextDouble();
     System.out.println("Digite o valor liquido: ");  
      double valorrecebido= s.nextDouble();
      double totaldescontado= (faturamento - valorrecebido);
      double percentagemimposto=(totaldescontado / faturamento * 100);
      System.out.println("A porcentagem é = " +percentagemimposto + " %"); 
    
    
    System.out.println("Ex. 8-  teste se um valor é par ou ímpar    ");
    System.out.println("Digite um número: ");
      int numero = s.nextInt();
      if (numero%2==0)
       {
  	    System.out.println("\n\n ESSE NÚMERO É PAR") ;
       }
      else
       {
  	     System.out.println("\n\n ESSE NÚMERO É iMPAR") ;
       }
     
     System.out.println("Ex. 9-  compare dois valores Strings    ");  
      String string1 = "s";
      String string2 = "s";
      System.out.println(string1.equals(string2));
       
     System.out.println("Ex. 10-  variável com ponto em String e converta seu valor para inteiro     ");  
       
    
    
    

}  
    
}