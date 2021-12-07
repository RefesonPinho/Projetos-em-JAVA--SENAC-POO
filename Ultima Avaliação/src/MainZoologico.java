// Importando as bibliotecas padrões e os modelos.
import java.util.Scanner;

import model.Leao;



// Criando o programa principal do sistema.
public class MainZoologico {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        //Criando os menus de escolha do Crud do Cliente e do chef e informações das padarias, mercados e receitas
        do {
            System.out.println("Sistema de cadastro geral e acesso da Padaria: ");
            System.out.println("\n");
            System.out.println("Crud de Cliente: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. SELECT CLIENTE COM STATEMENT");
            System.out.println("2. INSERT CLIENTE COM PREP STATEMENT");
            System.out.println("3. UPDATE CLIENTE COM STATEMENT");
            System.out.println("4. DELETE CLIENTE COM PREP STATEMENT");
            System.out.println("\n");
            System.out.println("Crud de Chef: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("5. SELECT CHEF  COM PREP STATEMENT");
            System.out.println("6. INSERT CHEF STATEMENT");
            System.out.println("7. UPDATE CHEF COM PREP STATEMENT");
            System.out.println("8. DELETE CHEF COM STATEMENT");
            System.out.println("\n");
            System.out.println("9.Dados da primeira Padaria");
            System.out.println("10.Dados da segunda Padaria");
            System.out.println("11.Dados da terceira Padaria");
            System.out.println("\n");
            System.out.println("12.Dados do primeiro Mercado");
            System.out.println("13.Dados do segundo Mercado");
            System.out.println("14.Dados do terceiro Mercado");
            System.out.println("\n");
            System.out.println("15.Dados da primeira Receita");
            System.out.println("16.Dados da segunda Receita");
            System.out.println("17.Dados da terceira Receita");
            System.out.println("18.Dados da quarta Receita");
            System.out.println("19.Dados da quinta Receita");
            System.out.println("20.Dados da sexta Receita");
            System.out.println("21.Dados da setima Receita");
            System.out.println("22.Dados da oitava Receita");
            System.out.println("23.Dados da nona Receita");
            System.out.println("24.Dados da decima Receita");
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            //Chamando os metodos da escolha do menu apartir do cases da chave Switch menu.    
            }
            switch (menu) {
                case 1:
                    try {
                        Leao.printLeao(
                            Leao.getLeaoS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Leao.insertLeaoPS(
                            Leao.getLeaoInsert(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Leao.updateLeaoS(
                            Leao.getLeaoUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Leao.deleteLeaoPS(
                            Leao.getLeao(scanner)                     
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        Chef.printChef(
                            Chef.getChefPS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Chef.insertChefS(
                            Chef.getChefInsertChef(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        Chef.updateChefPS(
                            Chef.getChefUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        Chef.deleteChefS(
                            Chef.getChef(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println(Padaria.dadosPadariaum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println(Padaria.dadosPadariadois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    try {
                        System.out.println(Padaria.dadosPadariatres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    try {
                        System.out.println(Mercados.dadosMercadosum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    try {
                        System.out.println(Mercados.dadosMercadosdois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 14:
                    try {
                        System.out.println(Mercados.dadosMercadostres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 15:
                    try {
                        System.out.println(Receita.dadosReceitaum());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 16:
                    try {
                        System.out.println(Receita.dadosReceitadois());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
            case 17:
                    try {
                        System.out.println(Receita.dadosReceitatres());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 18:
                    try {
                        System.out.println(Receita.dadosReceitaquatro());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 19:
                    try {
                        System.out.println(Receita.dadosReceitacinco());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 20:
                    try {
                        System.out.println(Receita.dadosReceitaseis());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 21:
                    try {
                        System.out.println(Receita.dadosReceitasete());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 22:
                    try {
                        System.out.println(Receita.dadosReceitaoito());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                case 23:
                    try {
                        System.out.println(Receita.dadosReceitanove());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 24:
                    try {
                        System.out.println(Receita.dadosReceitadez());
                            
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;             
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
        scanner.close();
    }
}
