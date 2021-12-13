// Importando as bibliotecas padrões e as packages.
package src.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import src.model.Golfinho;
import src.model.Jaula;

// Criando a classe DAO.
public class GolfinhoDAO {
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

    //Criando os métodos do Crud do Golfimho no banco de dados
    
    public static void SelectGolfinhoS(Golfinho golfinho)throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            String sql1 = "SELECT * FROM golfinho";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery(sql1);
            while (rs.next()) {
                stm.execute("SELECT * FROM jaula WHERE id = " + rs.getInt("jaula_id"));
               golfinho = new Golfinho(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("treinamento"),
                        rs.getInt("jaula_id"));
                        System.out.println(golfinho);
            }
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }    
    }

    public static Golfinho getGolfinhoInsert(Scanner scanner) {
        System.out.println("Informe o nome do Golfinho");
        String nome = scanner.next();
        System.out.println("Informe o número de Treinamento do Golfinho");
        int treinamento = scanner.nextInt();
        System.out.println("Informe a jaula do Golfinho");
        int jaula = scanner.nextInt();
        return new Golfinho(
            nome,
            treinamento,
            jaula
        );
    }

    public static void insertGolfinhoS(Golfinho golfinho, Jaula jaula) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://loc5alhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into jaula (id, descricao) VALUES ('"+jaula.getIdJaula()+"', '"+jaula.getDescricao()+"')");
            System.out.println("Jaula adicionada com sucesso"); 
            stm.execute("INSERT INTO golfinho "
                + "(nome, treinamento,jaula_id) VALUES "
                + "('"+golfinho.getNome()+"', '"+golfinho.getTreinamento()+"', '"+golfinho.getJaula().getIdJaula());
            System.out.println("Dados inseridos com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  getGolfinho(int id) throws Exception {
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + id);
        
            if (!rs.next()) {
                throw new Exception("Id inválido");
            }
            Golfinho golfinho = new Golfinho(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("treinamento"),
                rs.getInt("jaula_id"));
                System.out.println(golfinho);
        
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateGolfinhoPS(Golfinho golfinho,Jaula jaula) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Atualizando dados no banco de dados");
            PreparedStatement pStm = con.prepareStatement("UPDATE golfinho SET "
                            + " nome = ?"
                            + ", treinamento = ?"
                            + ", jaula_id = ?"
                            + " WHERE id = ?");
            pStm.setString(1, golfinho.getNome());
            pStm.setInt(3, golfinho.getTreinamento());
            pStm.setInt(4, golfinho.getJaula().getIdJaula());
            pStm.setInt(5, golfinho.getIdAnimal());
            System.out.println("Dados atualizados com sucesso"); 
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void deleteGolfinhoS(int id) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement statement = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Excluindo dados no banco de dados");
            statement.execute("DELETE FROM golfinho WHERE id = "+ id);
            System.out.println("\n Golfinho deletado com sucesso! ");
            
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}