package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import src.model.Leao;

public class LeaoDAO {
    private Connection connection;

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM leao;");
            ArrayList<Leao> leaos = new ArrayList<>();
            while (rs.next()) {
                leaos.add(
                    new Leao(
                        rs.getString("nome"),
                        rs.getInt("alimentacao"),
                        rs.getInt("visitantes"),
                        rs.getInt("jaula_id"),
                        rs.getString("descricao")
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
        System.out.println("Informe o intervalo de alimentação do Leao");
        int alimentacao = scanner.nextInt();
        System.out.println("Informe a quantiadade de visitantes do Leão");
        int visitantes = scanner.nextInt();
        System.out.println("Informe a descrição do Leão ");
        String descricao = scanner.next();

        return new Leao(
            nome,
            alimentacao,
            visitantes,
            descricao
        );
    }

    public static void insertLeaoPS(Leao leao) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            PreparedStatement stm = con.prepareStatement("INSERT INTO leao "
                            + "(nome, alimentacao, visitantes, descricao) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, leao.getNome());
            stm.setInt(2, leao.getAlimentacao());
            stm.setInt(3, leao.getVisitantes());
            stm.setString(4, leao.getJaula().getDescricao());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    ResultSet queryRs = stm.executeQuery("SELECT * FROM leao WHERE id = " + rs.getInt(1));
                    queryRs.next();
                    System.out.println(new Leao(
                        rs.getString("nome"),
                        rs.getInt("alimentacao"),
                        rs.getInt("visitantes"),
                        rs.getInt("jaula_id"),
                        rs.getString("descricao")
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
            Leao leao = getLeao(scanner);
            System.out.println("Informe o nome do Leão (Deixar vazio para manter)");
            String nome = scanner.next();
            leao.setNome(nome);
            System.out.println("Informe o intervalo de alimentação do Leão (Deixar vazio para manter)");
            int alimentacao = scanner.nextInt();
            if (alimentacao > 0){
                leao.setAlimentacao(alimentacao);
            }
            System.out.println("Informe a quantiadade de visitantes do Leão (Deixar vazio para manter)");
            int visitantes = scanner.nextInt();
            if (visitantes  > 0){
                leao.setVisitantes(visitantes);
            }
            System.out.println("Informe o número da Jaula do Leão (Deixar vazio para manter)");
            int jaulaId = scanner.nextInt();
            if (jaulaId > 0){
                leao.getJaula().getIdJaula();
            }
            return leao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateLeaoS(Leao leao) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            stm.execute("UPDATE Leao SET "
                + " WHERE id = " + leao.getIdAnimal()
                + " nome = '" + leao.getNome() + "'"
                + ", alimentacao = '" + leao.getAlimentacao() + "'"
                + ", visitantes = '" + leao.getVisitantes() + "'"
                + ", jaula_id = '" + leao.getJaula().getIdJaula());
                System.out.println("Dados atualizados com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao getLeao(Scanner scanner) throws Exception { 
        try {
            System.out.println("Informe o ID do leao: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");

            ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            
            return new Leao(
                rs.getString("nome"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes"),
                rs.getInt("jaula_id"),
                rs.getString("descricao")

            );
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteLeaoPS(Leao leao) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            PreparedStatement pStm = con.prepareStatement("DELETE FROM leao WHERE id = ?");
            pStm.setInt(1, leao.getIdAnimal());
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