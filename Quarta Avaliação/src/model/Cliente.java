package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
// Importandos bibliotecas padrões.
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Criando a classe Cliente a partir da herança da classe Pai que é a classe Pessoass.
public class Cliente extends Pessoass {
    /// Encapsulando os atributos e criando collection com ArrayList através do relacionamento de classes.
    private int idCliente;
    private String telefone;
    private ArrayList<Receita> receitas = new  ArrayList <>();

    // Criando o construtor da classe Cliente.
    public Cliente(
        String nome,
        String cpf,
        String dataNascimento,
        int idCliente,
        String telefone
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoass.
      super(nome, cpf, dataNascimento);
        this.telefone = telefone;
        this.idCliente = idCliente;
    }

    public Cliente(
        String nome,
        String cpf,
        String dataNascimento,
        String telefone
    ){
        // Chamando o método da super classe que pertence a classe Pai Pessoass.
        super(nome, cpf, dataNascimento);
        this.telefone = telefone;
    }    
    // Criando os métodos setters e getters para poder ter acesso controlado aos atributos encapsulados.
    public void setTelefone( String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setIdCliente( int idCliente){
        this.idCliente = idCliente;
    }

    public int getidCliente(){
        return this.idCliente;
    }

    public Cliente id(int id) {
        setIdCliente(id);
        return this;
    }

    public Cliente nome(String nome) {
        setNome(nome);
        return this;
    }

    public Cliente cpf(String cpf) {
        setCPF(cpf);
        return this;
    }

    public Cliente dataNascimento(String dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    public Cliente especialidade(String telefone) {
        setTelefone(telefone);
        return this;
    }

    public void setReceita( Receita receita){
        this.receitas.add(receita);      
    }
    
    public ArrayList<Receita> getReceita(){
        return this.receitas;
    }
    
    // Fazendo uso do padrão de projeto Decorator 
    @Override
    public boolean equals(Object c) {
        if (c == this)
            return true;
        if (!(c instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) c;
        return Objects.equals(this.getCPF(), cliente.getCPF());
    }

    @Override
    public String toString() {
        String total="\nCliente: " 
            + getNome()+ " / " + "CPF:"
            + getCPF() + " / " + " Data de nascimento:" 
            + getDataNascimento() + " / " + "Telefone:" 
            + getTelefone() + "\n"  + "Quantidade de Receitas compradas por "
            + getNome() + " é:"
            + this.receitas.size() + "\n";
            
            for(Receita receita : this.receitas){
                total += "\n   "+ receita.getNomeReceita();
                

            };
        return total;    
    }

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
            Cliente cliente = Cliente.getCLiente(scanner);
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

    public static Receita dadosReceitaum() throws Exception {
        Receita receitaum =new Receita("21","Pão de Mel","preparar a massa e assar",2,"R$ 5,00",Chef.getChefPS().get(0));
        receitaum.getCliente().get(0);
        return dadosReceitaum();
    }

    public static Receita dadosReceitadois() throws Exception {
        Receita receitadois = new Receita("87","Bolo de chocolate","Separar os ingredientes,prepara-los e fazer o bolo",3,"RS 2", Chef.getChefPS().get(1));
        Cliente.getclienteS().get(1).setReceita(dadosReceitaum());
        return receitadois;
    }

    public static Receita dadosReceitatres() throws Exception{
        Receita receitatres = new Receita("65","Pão Francês","preparar a massa e assar",2," R$ 6,50 Kg",Chef.getChefPS().get(2));
        return receitatres;
    }

    public static Receita dadosReceitaquatro() throws Exception {
        Receita receitaquatro =  new Receita("32","Torta de Coco com chocolate","Separar os ingredientes,prepara-los e fazer a torta",3," R$ 15",Chef.getChefPS().get(0));
        return receitaquatro;
    }

    public static Receita dadosReceitacinco() throws Exception {
        Receita receitacinco = new Receita("41","Chineque convencional","preparar a massa e assar",2,"R$ 2",Chef.getChefPS().get(1));
        return  receitacinco;
    }

    public static Receita dadosReceitaseis() throws Exception{
        Receita receitaseis = new Receita("04","Orelha de gato","Separar todos os ingredientes,preparar a massa e assar",3," R$ 3",Chef.getChefPS().get(2));
        return receitaseis;
    }
    
    public static Receita dadosReceitasete() throws Exception {
        Receita receitasete = new Receita("45","Torta de Limão","Separar os ingredientes,prepara-los e fazer o bolo",3,"R$ 12",Chef.getChefPS().get(0));
        return receitasete;
    }

    public static Receita dadosReceitaoito() throws Exception {
        Receita receitaoito = new Receita("5","Coxinha de frango","Separar os ingredientes,prepara-los e fazer a coxinha",3,"R$ 3",Chef.getChefPS().get(1));
        return receitaoito;
    }

    public static Receita dadosReceitanove() throws Exception{
        Receita receitanove = new Receita("8","Bananada","Separar os ingredientes,prepara-los, assar a massa e jogar açucar em cima da massa pronta",4,"R$ 3",Chef.getChefPS().get(2));
        return receitanove;
    }

    public static Receita dadosReceitadez() throws Exception{
        Receita receitadez =new Receita("43","Coxinha de carne","Separar os ingredientes,prepara-los e fazer a coxinha",3," R$ 3",Chef.getChefPS().get(0));
        return receitadez;
    }
}