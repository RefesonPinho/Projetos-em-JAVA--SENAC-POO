// Importando as bibliotecas padrões e as packages.
package src.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import src.model.Leao;


// Criando a classe DAO.
public class LeaoDAO {
    private Connection connection;
    // Criando as regras de negocio do CRUD e da conexão ao banco de dados.
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

    
    public static void SelectLeaoS(Leao leao) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            String sql1 = "SELECT * FROM leao";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery(sql1);
            while (rs.next()) {
                stm.execute("SELECT * FROM jaula WHERE id = " + rs.getInt("jaula_id"));
               leao = new Leao(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("alimentacao"),
                        rs.getInt("visitantes"),
                        rs.getInt("jaula_id"));
                        System.out.println(leao);
            }
            con.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }


    
    public static void insertLeaoS(Leao leao) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("INSERT INTO leao "
                + "(nome, alimentacao,visitantes,jaula_id) VALUES "
                + "('"+leao.getNome()+"', '"+leao.getAlimentacao() +"', '"+leao.getVisitantes()+"', '"+leao.getJaula().getIdJaula());
            
            System.out.println("Dados inseridos com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao getLeaoUpdate(Scanner scanner) throws Exception {
        try {
            Leao leao = getLeao(scanner);
            System.out.println("Informe o nome Id )");
            int id = scanner.nextInt();
            leao.setIdAnimal(id);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);
        
            if (!rs.next()) {
                throw new Exception("Id inválido");
            }
            return new Leao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes"),
                rs.getInt("jaula_id"));
        
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
            stm.execute("UPDATE leao SET "
                + " nome = '" + leao.getNome() + "'"
                + ", alimentacao = '" + leao.getAlimentacao() + "'"
                + ", visitantes = '" + leao.getVisitantes() + "'"
                + ", jaula_id = '" + leao.getJaula().getIdJaula()+ "'"
                + " WHERE id = " + leao.getIdAnimal());
                System.out.println("Dados atualizados com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao getLeao(Scanner scanner) throws Exception { 
        try {
            
            System.out.println("Informe o  Id do Golfinho )");
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
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes"),
                rs.getInt("jaula_id")
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