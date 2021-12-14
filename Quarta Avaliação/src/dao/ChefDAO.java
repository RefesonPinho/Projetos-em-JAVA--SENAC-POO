// Importando as bibliotecas padrões e as packages.
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.Chef;

// Criando a classe DAO.
public class ChefDAO {
    private Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    // Criando as regras de negocio do CRUD e da conexão ao banco de dados.
 
    public static void printChef(
        ArrayList<Chef> chefs
    ) {
        try {
            for (Chef chef : chefs) {
                System.out.println(chef);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Chef> getChefPS() throws Exception {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Mostrando dados presente no banco de dados");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM chef;");
            ResultSet rs = stm.executeQuery();
            ArrayList<Chef> chefs = new ArrayList<>();
            while (rs.next()) {
                chefs.add(
                    new Chef(
                       rs.getString("nome"),
                       rs.getString("cpf"),
                       rs.getString("dataNascimento"),
                       rs.getInt("idChef"),
                       rs.getString("especialidade")
                    )
                );
            }
            con.close();
            return chefs;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }    
    }
    

    public static Chef getChefInsertChef(Scanner scanner) {
        System.out.println("Informe o nome do Chef");
        String nome = scanner.next();
        System.out.println("Informe o CPF do Chef");
        String cpf = scanner.next();
        System.out.println("Informe a Data de Nascimento do Chef");
        String dataNascimento = scanner.next();
        System.out.println("Informa especialidade do Chef");
        String especialidade = scanner.next();
        return new Chef(
            nome,
            cpf,
            dataNascimento,
            especialidade
        );
    }

    public static void insertChefS(Chef chef) {
        try{
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Inserindo dados no banco de dados");
            stm.execute("INSERT INTO chef "
                + "(nome, cpf, dataNascimento, especialidade) VALUES "
                + "('"+chef.getNome()+"', '"+chef.getCPF()+"', '"+chef.getDataNascimento()+"', '"+chef.getEspecialidade()+"')");
            System.out.println("Dados inseridos com sucesso"); 
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Chef getChefUpdate(Scanner scanner) throws Exception {
        try {
           Chef chef  = getChef(scanner);
            System.out.println("Informe o nome do Chef (Deixar vazio para manter)");
            String nome = scanner.next();
            if (nome.length() > 0){
                chef.setNome(nome);
            }
            System.out.println("Informe o CPF do Chef (Deixar vazio para manter)");
            String cpf = scanner.next();
            if (cpf.length() > 0){
                chef.setCPF(cpf);
            }
            System.out.println("Informe a Data de Nascimento do Chef (Deixar vazio para manter)");
            String dataNascimento = scanner.next();
            if (dataNascimento.length() > 0){
                chef.setCPF(cpf);
            }
            System.out.println("Informe a especialidade do Chef (Deixar vazio para manter)");
            String especialidade = scanner.next();
            if (especialidade.length() > 0){
                chef.setEspecialidade(especialidade);
            }

            return chef;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void updateChefPS(Chef chef) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("Banco de Dados conectado");
            System.out.println("Atualizando dados no banco de dados");
            PreparedStatement pStm = con.prepareStatement("UPDATE chef SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", dataNascimento = ?"
                            + ", especialidade = ?"
                            + " WHERE idChef = ?");
            pStm.setString(1, chef.getNome());
            pStm.setString(2, chef.getCPF());
            pStm.setString(3, chef.getDataNascimento());;
            pStm.setString(4, chef.getEspecialidade());
            pStm.setInt(5, chef.getIdChef());
            System.out.println("Dados atualizados com sucesso"); 
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Chef getChef(Scanner scanner) throws Exception { 
        try {
            
            System.out.println("Informe o ID do Chef: ");
            int id = scanner.nextInt();
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE idChef = " + id);
            
            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            return new Chef(
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("dataNascimento"),
                rs.getInt("idChef"),
                rs.getString("especialidade")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteChefS(Chef chef) {
        try {
            System.out.println("Conectando ao banco de dados");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?useTimezone=true&serverTimezone=UTC", "root", "");
            Statement stm = con.createStatement();
            System.out.println("Banco de Dados conectado");
            System.out.println("Deletando Dados do banco");
            stm.execute("DELETE FROM chef "
                + " WHERE idChef = " + chef.getIdChef());
            System.out.println("Dados deletado com sucesso");    
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}