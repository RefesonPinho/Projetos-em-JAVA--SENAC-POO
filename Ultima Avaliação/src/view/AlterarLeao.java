// Importando as bibliotecas padrões e as packages.
package src.view;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import src.model.Leao;
import src.model.Jaula;
import src.dao.LeaoDAO;

// Criando a classe AlterarLeao a partir da herança da classe Pai que é a classe JFrame.
public class AlterarLeao extends JFrame{
    
    // Criando a classe construtora
    public AlterarLeao(){
        // Criando os botões, as label e os tratamentos de eventos
        JLabel title = new JLabel(" -- Alterar o cadastro do Leão -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do leão: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoId = new JLabel("Informe o id do Leão: ", JLabel.CENTER);
        JTextField insertID = new JTextField(15);
        JLabel infoAlimento = new JLabel("Informe a quantidade de alimento: ", JLabel.CENTER);
        JTextField insertAlimento = new JTextField(15);
        JLabel infoVisita = new JLabel("Informe a quantidade de visitantes: ", JLabel.CENTER);
        JTextField insertVisita = new JTextField(15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoId);
        pane.add(insertID);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoAlimento);
        pane.add(insertAlimento);
        pane.add(infoVisita);
        pane.add(insertVisita);
        pane.add(cadastrar);
        pane.add(voltar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,400);
        this.setResizable(false);
        this.setVisible(true);

        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                new ZoologicoBahia();
            }
        });
    }
    
    // Metodo para Alterar Leão
    public static void selectLeao(int id) throws Exception {
        try{     
            LeaoDAO.getLeao(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateLeao(Leao leao, Jaula jaula) throws Exception {
        LeaoDAO.updateLeaoS(leao, jaula);
    }
}
