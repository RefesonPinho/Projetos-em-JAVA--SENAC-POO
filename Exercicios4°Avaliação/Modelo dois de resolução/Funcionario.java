// Importandos bibliotecas padrões.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
// Criando a classe Funcionario.
public class Funcionario {
    /// Encapsulando os atributos.
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String matricula;
    /// Dados de acesso ao banco de dados.
    private final static String url = "jdbc:mysql://localhost:3306/empresa";
    private final static String user = "root";
    private final static String password = "";

    // Criando o construtor da classe Funcionario.
    public Funcionario(int id, String nome, String cpf, String dataNascimento, String matricula) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }
    // Criando o construtor da classe Funcionario com outra assinatura.
    public Funcionario(String nome, String cpf, String dataNascimento, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }   

    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Funcionario id(int id) {
        setId(id);
        return this;
    }

    public Funcionario nome(String nome) {
        setNome(nome);
        return this;
    }

    public Funcionario cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Funcionario dataNascimento(String dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    public Funcionario matricula(String matricula) {
        setMatricula(matricula);
        return this;
    }

    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Funcionario)) {
            return false;
        }
        Funcionario funcionario = (Funcionario) o;
        return id == funcionario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNascimento, matricula);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", cpf='" + getCpf() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", matricula='" + getMatricula() + "'" +
            "}";
    }

    //Criando os métodos do Crud do Funcionario no banco de dados
    public static void printFuncionario(
        ArrayList<Funcionario> funcionarios
    ) {
        try {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Funcionario> getFuncionarioS() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios;");
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                funcionarios.add(
                    new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("dataNascimento"),
                        rs.getString("matricula")
                    )
                );
            }
            con.close();
            return funcionarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }             
    }

    public static ArrayList<Funcionario> getFuncionarioPS() throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement("SELECT * FROM funcionarios;");
            ResultSet rs = stm.executeQuery();
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                funcionarios.add(
                    new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("dataNascimento"),
                        rs.getString("matricula")
                    )
                );
            }
            con.close();
            return funcionarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }  
    }

    public static Funcionario getFuncionarioInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do funcionário");
        String nome = scanner.next();
        System.out.println("Informe o CPF do funcionário");
        String cpf = scanner.next();
        System.out.println("Informe a Data de Nascimento do funcionário");
        String dataNascimento = scanner.next();
        System.out.println("Informe o Matricula do funcionário");
        String matricula = scanner.next();
        scanner.close();

        return new Funcionario(
            nome,
            cpf,
            dataNascimento,
            matricula
        );
    }
    
    public static void insertFuncionarioS(Funcionario funcionario) {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("INSERT INTO funcionarios "
                + "(nome, cpf, dataNascimento, matricula) VALUES "
                + "('"+funcionario.getNome()+"', '"+funcionario.getCpf()+"', '"+funcionario.getDataNascimento()+"', '"+funcionario.getMatricula()+"')");
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertFuncionarioPS(Funcionario funcionario) {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement("INSERT INTO funcionarios "
                            + "(nome, cpf, dataNascimento, matricula) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getCpf());
            stm.setString(3,funcionario.getDataNascimento());
            stm.setString(4, funcionario.getMatricula());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    System.out.println(new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("dataNascimento"),
                        rs.getString("matricula")
                    )); 
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Funcionario getFuncionarioUpdate() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            Funcionario funcionario = Funcionario.getFuncionario();
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
                funcionario.setDataNascimento(dataNascimento);
            }
            System.out.println("Informe o Matricula do funcionário (Deixar vazio para manter)");
            String matricula = scanner.next();
            if (matricula.length() > 0){
                funcionario.setMatricula(matricula);
            }
            scanner.close();
            return funcionario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateFuncionarioS(Funcionario funcionario) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("UPDATE funcionarios SET "
                + " nome = '" + funcionario.getNome() + "'"
                + ", cpf = '" + funcionario.getCpf() + "'"
                + ", dataNascimento = '" + funcionario.getDataNascimento() + "'"
                + ", matricula = '" + funcionario.getMatricula() + "'"
                + " WHERE id = " + funcionario.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateFuncionarioPS(Funcionario funcionario) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("UPDATE funcionarios SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", dataNascimento = ?"
                            + ", matricula = ?"
                            + " WHERE id = ?");
            pStm.setString(1, funcionario.getNome());
            pStm.setString(2, funcionario.getCpf());
            pStm.setString(3,funcionario.getDataNascimento());
            pStm.setString(4, funcionario.getMatricula());
            pStm.setInt(5, funcionario.getId());
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Funcionario getFuncionario() throws Exception { 
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o ID de exclusão: ");
            int id = scanner.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM funcionarios WHERE id = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            scanner.close();
            return new Funcionario(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("dataNascimento"),
                rs.getString("matricula")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteFuncionarioS(Funcionario funcionario) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("DELETE FROM funcionarios "
                + " WHERE id = " + funcionario.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFuncionarioPS(Funcionario funcionario) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
            pStm.setInt(1, funcionario.getId());
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
