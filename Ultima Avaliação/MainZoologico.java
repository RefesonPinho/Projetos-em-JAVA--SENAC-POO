// Importando as bibliotecas padrões e os modelos.
import java.util.Scanner;

import dao.GolfinhoDAO;
import dao.LeaoDAO;



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
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            //Chamando os metodos da escolha do menu apartir do cases da chave Switch menu.    
            }
            switch (menu) {
                case 1:
                    try {
                        LeaoDAO.printLeao(
                            LeaoDAO.getLeao(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        LeaoDAO.insertLeaoPS(
                            LeaoDAO.getLeaoInsert(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        LeaoDAO.updateLeaoS(
                            LeaoDAO.getLeaoUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        LeaoDAO.deleteLeaoPS(
                            LeaoDAO.getLeao(scanner)                     
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        GolfinhoDAO.printGolfinho(
                            GolfinhoDAO.getGolfinhoPS(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        GolfinhoDAO.insertGolfinhoS(
                            GolfinhoDAO.getGolfinhoPS(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        GolfinhoDAO.updateGolfinhoPS(
                            GolfinhoDAO.getGolfinhoUpdate(scanner)
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                       GolfinhoDAO.deleteGolfinhoS(
                           GolfinhoDAO.getGolfinho(scanner)
                        );
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
