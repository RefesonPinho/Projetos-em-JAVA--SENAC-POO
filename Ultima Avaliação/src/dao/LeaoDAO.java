// Importando as bibliotecas padrões e as packages.
package src.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.model.Alimentacao;
import src.model.Jaula;
import src.model.Leao;


// Criando a classe DAO.
public class LeaoDAO {
    private Connection connection;
    private static ResultSet rsAliment;
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



    //Criando os métodos do Crud do Leão no banco de dados

    public static void SelectLeaoS(Leao leao) throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            ResultSet rs = stm.executeQuery("SELECT * FROM leao l INNER JOIN jaula j ON l.jaula_id = j.id");
            while (rs.next()) {
               leao = new Leao(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("alimentacao"),
                    rs.getInt("visitantes"),
                    rs.getInt("jaula_id"));
                    rsAliment = stm.executeQuery("SELECT * FROM alimentacao WHERE idAlimentacao = " +  rsAliment.getInt("idAlimentacao"));
                    while (rsAliment.next()) {
                        new Alimentacao (
                            rsAliment.getInt("id"),
                            Date.valueOf("1990-01-01"),
                            rsAliment.getString("detalhes"),
                            leao
                            );            
                        System.out.println(leao);
                    }
            }        
            con.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }
    
    public static void insertLeaoS(Leao leao,Jaula jaula) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("Insert into jaula " + "(descricao) VALUES  ('"+jaula.getDescricao()+"')");
            System.out.println("Jaula adicionada com sucesso");
            stm.execute("INSERT INTO leao "
                + "(nome, alimentacao, visitantes, jaula_id) VALUES "
                + "('"+leao.getNome()+"', '"+leao.getAlimentacao()+"', '"+leao.getVisitantes()+"', '"+leao.getJaula().getIdJaula()+"')");
            System.out.println("Dados inseridos com sucesso");
            System.out.println(leao); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  getLeao(int id) throws Exception {
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);
        
            if (!rs.next()) {
                throw new Exception("Id inválido");
            }
            Leao leao= new Leao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes"),
                rs.getInt("jaula_id"));
                System.out.println(leao);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateLeaoS(Leao leao, Jaula jaula) {
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

    public static void deleteLeaoPS(int id) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement statement = con.createStatement();
            boolean sql = statement.execute("DELETE FROM leao WHERE id = "+ id);
            if(!sql){
                System.out.println("\n Leão deletado com sucesso! ");
            } else {
                System.out.println("\n Deu ruim, leão não foi deletado! ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}