// Importando as bibliotecas padrões e as packages.
package src.view;
import java.sql.SQLException;
import src.dao.LeaoDAO;
import src.model.Leao;
import javax.swing.*;
import java.awt.*;

// Criando a classe ListarLeao a partir da herança da classe Pai que é a classe JFrame.
public class ListarLeao extends JFrame{

    // Criando a classe construtora
    public ListarLeao(){

        // Criando os botões, as label e os tratamentos de eventos
        JLabel listar = new JLabel("-- Listar Leão! --", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(listar);
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


    // Metodo para selecionar os Leõs
    public static void selectLeao(Leao leao) throws Exception {
        try {
                LeaoDAO.SelectLeaoS(leao);
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

