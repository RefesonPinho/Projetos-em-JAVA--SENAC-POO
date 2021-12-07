package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.Leao;

public class LeaoDAO {
    private Connection connection;
    private final static String url = "jdbc:mysql://localhost:3306/company";
    private final static String user = "root";
    private final static String password = "";

    public int insert(String sql, Object[] atribs) throws Exception {
        try{
            PreparedStatement statement = this.startConnection().prepareStatement(
                sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Atribui os valores
            insertAtribs(statement, atribs);

            // Verifica se o retorno é um valor criado
            if(statement.executeUpdate() > 0){
                ResultSet resultado = statement.getGeneratedKeys();

                if(resultado.next()){
                    return resultado.getInt(1);
                }
            }

            return -1;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ResultSet select(String sql) throws Exception {
        try {
            Statement statement = this.startConnection().createStatement();
            ResultSet results = statement.executeQuery(sql);
            return results;
        }  catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void insertAtribs(PreparedStatement statement, Object[] atribs) throws SQLException {
        int idx = 1;
        for(Object atrib: atribs){
            if(atrib instanceof String) {
                statement.setString(idx, (String) atrib);
            } else if (atrib instanceof Integer){
                statement.setInt(idx, (Integer) atrib);
            } else if (atrib instanceof Double){
                statement.setDouble(idx, (Double) atrib);
            }
            idx++;
        }
    }
    public Connection startConnection() throws Exception {
        if(this.connection != null && !connection.isClosed()){
            return this.connection;
        }

        this.connection = getConnection();

        return this.connection;
    }

    public void endConnection() throws SQLException, Exception {
        startConnection().close();
    }

    private static Connection getConnection() throws Exception {
        try {
            final String url = "jdbc:mysql://localhost:3306/company";
            final String user = "root";
            final String password = "";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Criando os métodos do Crud do Cliente no banco de dados
    public static void printLeao(
        ArrayList<Leao> leaos
    ) {
        try {
            for (Leao leao : leaos) {
                System.out.println(leao);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Leao> getclienteS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM leao;");
            ArrayList<Leao> leaos = new ArrayList<>();
            while (rs.next()) {
                leaos.add(
                    new Leao(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("alimentacao"),
                        rs.getInt("visitantes"),
                        rs.getInt("jaula_id"),null
                    )
                );
            }
            con.close();
            return leaos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static Leao getLeaoInsert(Scanner scanner) {
        System.out.println("Informe o nome do Leao");
        String nome = scanner.next();
        System.out.println("Informe o CPF do Leao");
        int alimentacao = scanner.nextInt();
        System.out.println("Informe a Data de Nascimento do Leao");
        int visitantes = scanner.nextInt();
        System.out.println("Informe o telefone do Leao");
        int jaulaid = scanner.nextInt();

        return new Leao(
            nome,
            alimentacao,
            visitantes,
            jaulaid,null
        );
    }

    public static void insertLeaoPS(Leao leao) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            PreparedStatement stm = con.prepareStatement("INSERT INTO leao "
                            + "(nome, cpf, dataNascimento, telefone) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, leao.getNome());
            stm.setInt(2, leao.getAlimentacao());
            stm.setInt(3, leao.getVisitantes());
            stm.setInt(4, leao.getJaula().getIdJaula());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    ResultSet queryRs = stm.executeQuery("SELECT * FROM cliente WHERE id = " + rs.getInt(1));
                    queryRs.next();
                    System.out.println(new Leao(
                        queryRs.getInt("id"),
                        queryRs.getString("nome"),
                        queryRs.getInt("alimentacao"),
                        queryRs.getInt("vitaminas"),
                        queryRs.getInt("jaula_id"),null
                    ));
                    System.out.println("Dados inseridos com sucesso"); 
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao getLeaoUpdate(Scanner scanner) throws Exception {
        try {
            Leao leao = Leao.getLeao(scanner);
            System.out.println("Informe o nome do funcionário (Deixar vazio para manter)");
            String nome = scanner.next();
            if (nome.length() > 0){
                leao.setNome(nome);
            }
            System.out.println("Informe o CPF do funcionário (Deixar vazio para manter)");
            String cpf = scanner.next();
            if (cpf.length() > 0){
                leao.setCPF(cpf);
            }
            System.out.println("Informe a Data de Nascimento do funcionário (Deixar vazio para manter)");
            String dataNascimento = scanner.next();
            if (dataNascimento.length() > 0){
                leao.setDataNascimento(dataNascimento);
            }
            System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
            String telefone = scanner.next();
            if (telefone.length() > 0){
                leao.setTelefone(telefone);
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