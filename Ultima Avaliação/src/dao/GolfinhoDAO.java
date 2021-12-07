package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Golfinho;

public class GolfinhoDAO {
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

    public static void printGolfinho(
        ArrayList<Golfinho> golfinhos
    ) {
        try {
            for (Golfinho golfinho : golfinhos) {
                System.out.println(golfinho);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Golfinho> getGolfinhoPS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM golfinho;");
            ResultSet rs = stm.executeQuery();
            ArrayList<Golfinho> golfinhos = new ArrayList<>();
            while (rs.next()) {
                golfinhos.add(
                    new Golfinho(
                       rs.getInt("id"),
                       rs.getString("nome"),
                       rs.getInt("treinamento"),
                       rs.getInt("jaula_id"),null
                    )
                );
            }
            con.close();
            return golfinhos;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
          
    }

    public static void insertChefS(Golfinho golfinho) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            boolean sql = stm.execute("INSERT INTO golfinho "
                + "(nome, treinamento, jaula_id, descricao) VALUES "
                + "('"+golfinho.getNome()+"', '"+golfinho.getTreinamento()+"', '"+golfinho.getJaula().getIdJaula()+"')");
            System.out.println("Dados inseridos com sucesso"); 

            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateFuncionarioPS(Golfinho golfinho) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Banco de Dados conectado");
            System.out.println("Atualizando dados no banco de dados");
            PreparedStatement pStm = con.prepareStatement("UPDATE golfinho SET "
                            + " nome = ?"
                            + ", alimentacao = ?"
                            + ", visitantes = ?"
                            + ", jaula_id= ?"
                            + " WHERE id = ?");
            pStm.setString(1, golfinho.getNome());
            pStm.setInt(2, golfinho.getTreinamento());
            pStm.setInt(3, golfinho.getJaula().getIdJaula());
            System.out.println("Dados atualizados com sucesso"); 
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFuncionarioS(Golfinho golfinho) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            boolean sql = stm.execute("DELETE FROM golfinho "
                + " WHERE id = " + golfinho.getIdAnimal());
            System.out.println("Dados deletado com sucesso");    
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}