// Importando as bibliotecas padrões e as packages.
package src.view;
import javax.swing.*;
import src.dao.GolfinhoDAO;
import java.awt.*;

// Criando a classe ExcluirGolfinho a partir da herança da classe Pai que é a classe JFrame.
public class ExcluirGolfinho extends JFrame {

    // Criando a classe construtora
    public ExcluirGolfinho(){
        // Criando os botões, as label e os tratamentos de eventos
        JLabel titulo = new JLabel("-- Excluir Golfinhos! --    ", JLabel.CENTER);
        JLabel id = new JLabel("Informe o Id do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField informaId = new JTextField(15);
        JButton deletar = new JButton("Deletar");
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
    

    // Metodo para excluir Golfinho

    public static void deleteGolfinho(int id) throws Exception {
        GolfinhoDAO.deleteGolfinhoS(id);
    }
}
