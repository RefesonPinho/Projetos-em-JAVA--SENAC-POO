// Importando as bibliotecas padrões e as packages.
package src.view;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import src.dao.GolfinhoDAO;
import src.model.Golfinho;
import src.model.Jaula;

// Criando a classe AlterarGolfinho a partir da herança da classe Pai que é a classe JFrame.
public class AlterarGolfinho extends JFrame {

    // Criando a classe construtora
    public AlterarGolfinho(){
        // Criando os botões, as label e os tratamentos de eventos
        JLabel title = new JLabel(" -- CADASTRAR GOLFINHO! -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoId = new JLabel("Informe o id do Golfinho: ", JLabel.CENTER);
        JTextField insertID = new JTextField(15);
        JLabel infoTreino = new JLabel("Informe a quantidade de treinamento: ", JLabel.CENTER);
        JTextField insertTreino = new JTextField(15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoId);
        pane.add(insertID);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoTreino);
        pane.add(insertTreino);
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

    // Metodo para Alterar Golfinho
    public static void selectGolfinho(int id) throws Exception {
        try{     
            GolfinhoDAO.getGolfinho(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateGolfinho(Golfinho golfinho, Jaula jaula) throws Exception {
        GolfinhoDAO.updateGolfinhoPS(golfinho,jaula);
    }
}
