import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PrimeiraAvaliacao{

  public static void main(String[] args){

        try{
            System.out.println("1-Primeira Avaliação POO.");
            // Criar o buffer inicial e conta a quantidade de linhas do arquivo
            BufferedReader leitura = new BufferedReader(new FileReader("Textoavaliação.txt"));
            String value = "";
            int cont = 0;
            while (true){
                value = leitura.readLine();
                if(value != null){
                    cont ++;
                }else{
                    break;
                }
            }
            // Fechando o buffer
            leitura.close();
       
            // Criar o array com tamanho das linhas
            int [] array = new int[cont];
            cont = 0;


            // Lendo outra vez  o arquivo de buffer
            leitura = new BufferedReader(new FileReader("Textoavaliação.txt"));
            value = "";
            cont = 0;
            while (true){
                value = leitura.readLine();
                if(value != null){
                    
            //Aloca os valores nas posições
                   int numero = Integer.parseInt(value);
                   array[cont] = numero;
                   cont++;
                }else{

                    break;
                }
            }
            // Fechando o buffer
            leitura.close(); 
           
           
            //Ordenando o vetor
            int n = array.length;  
            int temp = 0;  
            for(int i=0; i < n; i++){  
                for(int j=1; j < (n-i); j++){  
                    if(array[j-1] > array[j]){  
            //trocar elementos 
                    temp = array[j-1];  
                    array[j-1] = array[j];  
                    array[j] = temp;  
                    }  
                        
                }  
            }  
            
            // Imprimindo o array ordenado no terminal
               
            System.out.println("Array ordenado em metodo Bolha");
            for(int i  : array){
                System.out.println(i);
            }
            
            
            
            // Criar o buffer inicial e conta a quantidade de linhas do arquivo
            leitura = new BufferedReader(new FileReader("Textoavaliação.txt"));
            value = "";
            cont = 0;
            while (true){
                value = leitura.readLine();
                if(value != null){
                     
                   //Aloco os valores nas posições
                    int numero1 = Integer.parseInt(value);
                    array[cont] = numero1;
                    cont++;
                }else{

                    break;
                }
            }
            // Fechando o buffer
            leitura.close(); 

            //Criando a Colection SortedSet
            SortedSet<Integer> ColecaoOrdenada = new TreeSet<>();
            
            
            //Ordenando a Colection SortedSet
            for(Integer numeros : array){
                ColecaoOrdenada.add(numeros);
                    
            }
            // Imprimindo o sortedset no terminal
            System.out.println("Colecão ordenada em SortedSet");
            for(Integer numeros : ColecaoOrdenada ){
                System.out.println(numeros);
            }

            // Criar o buffer de escrita(Writer)  e logo após salvar o Array ordenado em arquivo.txt
            BufferedWriter arquivoArray = new BufferedWriter(new FileWriter("Arraysalvo.txt"));
            //Ordenando o vetor
            int p = array.length;  
            int tempor = 0;  
            for(int i=0; i < p; i++){  
                for(int j=1; j < (p-i); j++){  
                    if(array[j-1] > array[j]){  
            //trocar elementos 
                    tempor = array[j-1];  
                    array[j-1] = array[j];  
                    array[j] = tempor;  
                    }  
                        
                }  
            }  
            
            //Salvado o Array ordenado no arquivo ArraySalvo.txt
            for(int i  : array){
                arquivoArray.append(i + "\n");  
            }
            // Fechando o buffer
            arquivoArray.close();                 




            // Criar o buffer de escrita(Writer)  e logo após salvar a Coleçaõ ordenada em arquivo.txt
            BufferedWriter arquivoColection = new BufferedWriter(new FileWriter("Colectionsalvo.txt"));
            //Salvando a Colecão ordenada no arquivo Colectionsalvo.txt
            for(Integer numeros : ColecaoOrdenada ){
                arquivoColection.append(numeros + "\n" );
            }
            // Fechando o buffer
            arquivoColection.close();
            
            System.out.println("PROGRAMA FINALIZADO COM SUCESSO! O PAI TA ON!");


        }catch (IOException exception ){
            System.out.println("arquivo não encontrado: " + exception.getMessage());
        }
                   
    }
}

