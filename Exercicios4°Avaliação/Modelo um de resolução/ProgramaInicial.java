import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProgramaInicial {

    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/company";
        final String user = "root";
        final String password = "";
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
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM funcionarios;");
                        while(sql.next()) {
                            System.out.println(new Funcionario(
                                sql.getInt("id"),
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getDate("data_nascimento"),
                                sql.getString("matricula")
                            ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("SELECT * FROM funcionarios;");
                        ResultSet sql = stm.executeQuery();
                        while(sql.next()) {
                            System.out.println(new Funcionario(
                                sql.getInt("id"),
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getDate("data_nascimento"),
                                sql.getString("matricula")
                            ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Informe o nome do funcionário");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF do funcionário");
                        String cpf = scanner.next();
                        System.out.println("Informe a Data de Nascimento do funcionário");
                        String dataNascimento = scanner.next();
                        System.out.println("Informe o Matricula do funcionário");
                        String matricula = scanner.next();
                        
                        
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO funcionarios "
                            + "(nome, cpf, data_nascimento, matricula) VALUES "
                            + "('"+nome+"', '"+cpf+"', '"+dataNascimento+"', '"+matricula+"')");
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Informe o nome do funcionário");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF do funcionário");
                        String cpf = scanner.next();
                        System.out.println("Informe a Data de Nascimento do funcionário");
                        String dataNascimento = scanner.next();
                        System.out.println("Informe o Matricula do funcionário");
                        String matricula = scanner.next();
                        
                        
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO funcionarios "
                            + "(nome, cpf, data_nascimento, matricula) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nome);
                        stm.setString(2, cpf);
                        stm.setDate(3, Date.valueOf(dataNascimento));
                        stm.setString(4, matricula);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                System.out.println(new Funcionario(
                                    rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getString("cpf"),
                                    rs.getDate("data_nascimento"),
                                    rs.getString("matricula")
                                )); 
                            }
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Informe o ID de alteração: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios WHERE id = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Funcionario funcionario = new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getDate("data_nascimento"),
                            rs.getString("matricula")
                        );
                        con.close();
                        System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            funcionario.setNome(nome);
                        }
                        System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            funcionario.setCpf(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
                        String dataNascimento = scanner.next();
                        if (dataNascimento.length() > 0){
                            funcionario.setDataNascimento(Date.valueOf(dataNascimento));
                        }
                        System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
                        String matricula = scanner.next();
                        if (matricula.length() > 0){
                            funcionario.setMatricula(matricula);
                        }
                        

                        con = DriverManager.getConnection(url, user, password);
                        stm = con.createStatement();
                        boolean sql = stm.execute("UPDATE funcionarios SET "
                            + " nome = '" + funcionario.getNome() + "'"
                            + ", cpf = '" + funcionario.getCpf() + "'"
                            + ", data_nascimento = '" + funcionario.getDataNascimento() + "'"
                            + ", matricula = '" + funcionario.getMatricula() + "'"
                            + " WHERE id = " + funcionario.getId());
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Informe o ID de alteração: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios WHERE id = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Funcionario funcionario = new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getDate("data_nascimento"),
                            rs.getString("matricula")
                        );
                        con.close();
                        System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            funcionario.setNome(nome);
                        }
                        System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            funcionario.setCpf(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
                        String dataNascimento = scanner.next();
                        if (dataNascimento.length() > 0){
                            funcionario.setDataNascimento(Date.valueOf(dataNascimento));
                        }
                        System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
                        String matricula = scanner.next();
                        if (matricula.length() > 0){
                            funcionario.setMatricula(matricula);
                        }
                        

                        con = DriverManager.getConnection(url, user, password);
                        PreparedStatement pStm = con.prepareStatement("UPDATE funcionarios SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", data_nascimento = ?"
                            + ", matricula = ?"
                            + " WHERE id = ?");
                        pStm.setString(1, funcionario.getNome());
                        pStm.setString(2, funcionario.getCpf());
                        pStm.setDate(3, funcionario.getDataNascimento());
                        pStm.setString(4, funcionario.getMatricula());
                        pStm.setInt(5, funcionario.getId());
                        if (pStm.executeUpdate() <= 0) {
                            System.out.println("Falha na execução.");
                        }
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Informe o ID de exclusão: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios WHERE id = " + id);
                        
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Funcionario funcionario = new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getDate("data_nascimento"),
                            rs.getString("matricula")
                        );
                        stm = con.createStatement();
                        boolean sql = stm.execute("DELETE FROM funcionarios "
                            + " WHERE id = " + funcionario.getId());
                        if(!sql) {
                            System.out.println("Falha na execução");
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Informe o ID de exclusão: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios WHERE id = " + id);
                        
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Funcionario funcionario = new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getDate("data_nascimento"),
                            rs.getString("matricula")
                        );
                        PreparedStatement pStm = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
                        pStm.setInt(1, funcionario.getId());
                        if(pStm.executeUpdate() <= 0) {
                            System.out.println("Falha na execução.");
                        }
                        con.close();
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
