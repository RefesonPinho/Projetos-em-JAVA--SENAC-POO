// Importandos bibliotecas padrões.
import java.sql.Connection;

// Criando a classe FuncionarioDAO.
public class FuncionarioDAO {
    private Connection con;
    // Criando as regras de negocio do CRUD e da conexão ao banco de dados.
    private final static String url = "jdbc:mysql://localhost:3306/empresa?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

}