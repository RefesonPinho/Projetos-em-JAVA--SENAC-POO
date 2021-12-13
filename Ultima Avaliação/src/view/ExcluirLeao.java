// Importando as bibliotecas padrões e as packages.
package src.view;
import javax.swing.*;
import src.dao.LeaoDAO;
import java.awt.*;

// Criando a classe ExcluirLeao a partir da herança da classe Pai que é a classe JFrame.
public class ExcluirLeao extends JFrame{

    // Criando a classe construtora
    public ExcluirLeao(){
        // Criando os botões, as label e os tratamentos de eventos
        JLabel titulo = new JLabel("-- Excluir Leão! --    ", JLabel.CENTER);
        JLabel id = new JLabel("\n Informe o Id do leão: ", JLabel.CENTER);
        JTextField informaId = new JTextField(15);
        JButton deletar = new JButton("Deletar");
        JButton voltar = new JButton("Voltar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(titulo);
        pane.add(id);
        pane.add(informaId);
        pane.add(deletar);
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

    // Metodo para excluir Leão

    public static void deleteLeao(int id) throws Exception {
        LeaoDAO.deleteLeaoPS(id);
    }
}
