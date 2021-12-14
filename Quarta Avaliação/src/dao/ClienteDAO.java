// Importando as bibliotecas padrões e as packages.
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;

// Criando a classe DAO.
public class ClienteDAO {
    private Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    // Criando as regras de negocio do CRUD e da conexão ao banco de dados do Cliente.
 
    public static void printCliente(
        ArrayList<Cliente> clientes
    ) {
        try {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Cliente> getclienteS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente;");
            ArrayList<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                clientes.add(
                    new Cliente(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("dataNascimento"),
                        rs.getInt("idCliente"),
                        rs.getString("telefone")
                    )
                );
            }
            con.close();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Cliente getClienteInsert(Scanner scanner) {
        System.out.println("Informe o nome do Cliente");
        String nome = scanner.next();
        System.out.println("Informe o CPF do Cliente");
        String cpf = scanner.next();
        System.out.println("Informe a Data de Nascimento do Cliente");
        String dataNascimento = scanner.next();
        System.out.println("Informe o telefone do Cliente");
        String telefone = scanner.next();

        return new Cliente(
            nome,
            cpf,
            dataNascimento,
            telefone
        );
    }

    public static void insertClientePS(Cliente cliente) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            PreparedStatement stm = con.prepareStatement("INSERT INTO cliente "
                            + "(nome, cpf, dataNascimento, telefone) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCPF());
            stm.setString(3, cliente.getDataNascimento());
            stm.setString(4, cliente.getTelefone());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    ResultSet queryRs = stm.executeQuery("SELECT * FROM cliente WHERE idCliente = " + rs.getInt(1));
                    queryRs.next();
                    System.out.println(new Cliente(
                        queryRs.getString("nome"),
                        queryRs.getString("cpf"),
                        queryRs.getString("dataNascimento"),
                        queryRs.getInt("idCliente"),
                        queryRs.getString("telefone")
                    ));
                    System.out.println("Dados inseridos com sucesso"); 
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getClienteUpdate(Scanner scanner) throws Exception {
        try {
            Cliente cliente = getCLiente(scanner);
            System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
            String nome = scanner.next();
            if (nome.length() > 0){
                cliente.setNome(nome);
            }
            System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
            String cpf = scanner.next();
            if (cpf.length() > 0){
                cliente.setCPF(cpf);
            }
            System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
            String dataNascimento = scanner.next();
            if (dataNascimento.length() > 0){
                cliente.setDataNascimento(dataNascimento);
            }
            System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
            String telefone = scanner.next();
            if (telefone.length() > 0){
                cliente.setTelefone(telefone);
            }
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateClienteS(Cliente cliente) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE cliente SET "
                + " nome = '" + cliente.getNome() + "'"
                + ", cpf = '" + cliente.getCPF() + "'"
                + ", dataNascimento = '" + cliente.getDataNascimento() + "'"
                + ", telefone = '" + cliente.getTelefone() + "'"
                + " WHERE idCliente = " + cliente.getidCliente());
                System.out.println("Dados atualizados com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getCLiente(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do Cliente: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE idCliente = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            return new Cliente(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("dataNascimento"),
                rs.getInt("idCliente"),
                rs.getString("telefone")
            );
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteClientePS(Cliente cliente) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            pStm.setInt(1, cliente.getidCliente());
            System.out.println("Dados deletado com sucesso");  
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}