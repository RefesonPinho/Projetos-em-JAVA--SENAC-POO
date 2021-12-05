import java.util.Scanner;

public class ProgramaInicialDois {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. SELECT COM STATEMENT");
            System.out.println("2. SELECT COM PREP STATEMENT");
            System.out.println("3. INSERT COM STATEMENT");
            System.out.println("4. INSERT COM PREP STATEMENT");
            System.out.println("5. UPDATE COM STATEMENT");
            System.out.println("6. UPDATE COM PREP STATEMENT");
            System.out.println("7. DELETE COM STATEMENT");
            System.out.println("8. DELETE COM PREP STATEMENT");
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            switch (menu) {
                case 1:
                    try {
                        Funcionario.printFuncionario(
                            Funcionario.getFuncionarioS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Funcionario.printFuncionario(
                            Funcionario.getFuncionarioPS()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Funcionario.insertFuncionarioS(
                            Funcionario.getFuncionarioInsert()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Funcionario.insertFuncionarioPS(
                            Funcionario.getFuncionarioInsert()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        Funcionario.updateFuncionarioS(
                            Funcionario.getFuncionarioUpdate()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Funcionario.updateFuncionarioPS(
                            Funcionario.getFuncionarioUpdate()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        Funcionario.deleteFuncionarioS(
                            Funcionario.getFuncionario()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        Funcionario.deleteFuncionarioPS(
                            Funcionario.getFuncionario()
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
