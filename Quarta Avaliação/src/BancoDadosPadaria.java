import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Chef;
import model.Cliente;

public class BancoDadosPadaria {

    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. SELECT CLIENTE COM STATEMENT");
            System.out.println("2. SELECT CHEF  COM PREP STATEMENT");
            System.out.println("3. INSERT CHEF STATEMENT");
            System.out.println("4. INSERT CLIENTE COM PREP STATEMENT");
            System.out.println("5. UPDATE CLIENTE COM STATEMENT");
            System.out.println("6. UPDATE CHEF COM PREP STATEMENT");
            System.out.println("7. DELETE CHEF COM STATEMENT");
            System.out.println("8. DELETE CLIENTE COM PREP STATEMENT");
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            switch (menu) {
                case 1:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        ResultSet sql = stm.executeQuery("SELECT * FROM cliente;");
                        while(sql.next()) {
                            System.out.println(new Cliente(
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getString("dataNascimento"),
                                sql.getInt("idCliente"),
                                sql.getString("telefone")
                            ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        PreparedStatement stm = con.prepareStatement("SELECT * FROM chef;?");
                        ResultSet sql = stm.executeQuery();
                        while(sql.next()) {
                            System.out.println(new Chef(
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getString("dataNascimento"),
                                sql.getInt("idChef"),
                                sql.getString("especialidade")
                            ));
                        }
                        con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Informe o nome do Chef");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF do Chef");
                        String cpf = scanner.next();
                        System.out.println("Informe a Data de Nascimento do Chef");
                        String dataNascimento = scanner.next();
                        System.out.println("Informe o especialidade do Chef");
                        String especialidade = scanner.next();
                        
                        
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Chef "
                            + "(nome, cpf, dataNascimento, especialidade) VALUES "
                            + "('"+nome+"', '"+cpf+"', '"+dataNascimento+"', '"+especialidade+"')");
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
                        System.out.println("Informe o nome do Cliente");
                        String nome = scanner.next();
                        System.out.println("Informe o CPF do Cliente");
                        String cpf = scanner.next();
                        System.out.println("Informe a Data de Nascimento do Cliente");
                        String dataNascimento = scanner.next();
                        System.out.println("Informe o telefone do Cliente");
                        String telefone = scanner.next();
                        
                        
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        PreparedStatement stm = con.prepareStatement("INSERT INTO Cliente "
                            + "(nome, cpf, dataNascimento, telefone) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nome);
                        stm.setString(2, cpf);
                        stm.setString(3,dataNascimento);
                        stm.setString(4, telefone);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                System.out.println(new Cliente(
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getString("dataNascimento"),
                                rs.getInt("idCliente"),
                                rs.getString("telefone")
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
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE idCliente = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Cliente cliente = new Cliente(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dataNascimento"),
                            rs.getInt("idCliente"),
                            rs.getString("telefone")
                        );
                        con.close();
                        System.out.println("Informe o nome do Cliente (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            cliente.setNome(nome);
                        }
                        System.out.println("Informe o CPF do Cliente (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            cliente.setCPF(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do Cliente (Deixar vazio para manter)");
                        String dataNascimento = scanner.next();
                        if (dataNascimento.length() > 0){
                            cliente.setDataNascimento(dataNascimento);
                        }
                        System.out.println("Informe o telefone do Cliente (Deixar vazio para manter)");
                        String telefone = scanner.next();
                        if (telefone.length() > 0){
                            cliente.setTelefone(telefone);
                        }
                        

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        stm = con.createStatement();
                        boolean sql = stm.execute("UPDATE cliente SET "
                            + " nome = '" + cliente.getNome() + "'"
                            + ", cpf = '" + cliente.getCPF() + "'"
                            + ", data_nascimento = '" + cliente.getDataNascimento() + "'"
                            + ", matricula = '" + cliente.getTelefone() + "'"
                            + " WHERE id = " + cliente.getidCliente());
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
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE idChef = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Chef chef = new Chef(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dataNascimento"),
                            rs.getInt("idChef"),
                            rs.getString("especialidade")
                        );
                        con.close();
                        System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            chef.setNome(nome);
                        }
                        System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            chef.setCPF(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
                        String dataNascimento = scanner.next();
                        if (dataNascimento.length() > 0){
                            chef.setDataNascimento(dataNascimento);
                        }
                        System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
                        String especialidade = scanner.next();
                        if (especialidade.length() > 0){
                            chef.setEspecialidade(especialidade);
                        }
                        

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        PreparedStatement pStm = con.prepareStatement("UPDATE chef SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", dataNascimento = ?"
                            + ", especialidade = ?"
                            + " WHERE idChef = ?");
                        pStm.setString(1, chef.getNome());
                        pStm.setString(2, chef.getCPF());
                        pStm.setString(3, chef.getDataNascimento());
                        pStm.setString(4, chef.getEspecialidade());
                        pStm.setInt(5, chef.getIdChef());
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
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE idChef = " + id);
                        
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Chef chef = new Chef(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dataNascimento"),
                            rs.getInt("idChef"),
                            rs.getString("especialidade")
                        );
                        stm = con.createStatement();
                        boolean sql = stm.execute("DELETE FROM chef "
                            + " WHERE id = " + chef.getIdChef());
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
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM clientes WHERE idCliente = " + id);
                        
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Cliente cliente = new Cliente(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dataNascimento"),
                            rs.getInt("idCliente"),
                            rs.getString("telefone")
                        );
                        PreparedStatement pStm = con.prepareStatement("DELETE FROM clientes WHERE idCliente = ?");
                        pStm.setInt(1, cliente.getidCliente());
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
