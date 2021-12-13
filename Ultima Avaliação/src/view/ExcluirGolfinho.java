package src.view;

import javax.swing.*;
import src.dao.GolfinhoDAO;


import java.awt.*;

public class ExcluirGolfinho extends JFrame {

    // CRIANDO O FRAME DE DELETAR O GOLFINHO
    public ExcluirGolfinho(){
        JLabel title = new JLabel("-- DELETAR GOLFINHO! --    ", JLabel.CENTER);
        JLabel selectId = new JLabel("Informe o Id do golfinho: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField informaId = new JTextField(15);
        JButton deletar = new JButton("Deletar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(selectId);
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
    

    // METODO PARA DELETAR O GOLFINHO INFORMADO

    public static void deleteGolfinho(int id) throws Exception {
        GolfinhoDAO.deleteGolfinhoS(id);
    }
}
