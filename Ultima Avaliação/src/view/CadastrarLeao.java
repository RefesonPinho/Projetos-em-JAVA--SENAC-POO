// Importando as bibliotecas padrões e as packages.
package src.view;
import javax.swing.*;
import java.awt.*;
import src.model.Leao;
import src.dao.LeaoDAO;
import src.model.Jaula;

// Criando a classe CadastrarLeao a partir da herança da classe Pai que é a classe JFrame.
public class CadastrarLeao extends JFrame{

    // Criando a classe construtora
    public CadastrarLeao(){
        // Criando os botões, as label e os tratamentos de eventos
        JLabel title = new JLabel(" -- CADASTRAR LEÃO! -- ", JLabel.CENTER);
        JLabel infoName = new JLabel("Informe o nome do leão: ", JLabel.CENTER);
        JButton voltar = new JButton("Voltar");
        JTextField insertName = new JTextField(15);
        JLabel infoAlimento = new JLabel("Informe a quantidade de alimento: ", JLabel.CENTER);
        JTextField insertAlimento = new JTextField(15);
        JLabel infoVisita = new JLabel("Informe a quantidade de visitantes: ", JLabel.CENTER);
        JTextField insertVisita = new JTextField(15);
        JLabel descricao = new JLabel("Descrição: ", JLabel.CENTER);
        JTextArea insertDesc = new JTextArea(10, 15);
        JButton cadastrar = new JButton("Cadastrar");
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(title);
        pane.add(infoName);
        pane.add(insertName);
        pane.add(infoAlimento);
        pane.add(insertAlimento);
        pane.add(infoVisita);
        pane.add(insertVisita);
        pane.add(descricao);
        pane.add(insertDesc);
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

    // Metodo para cadastrar Leão
    public static void insertLeao(Leao leao,Jaula jaula) throws Exception {
        LeaoDAO.insertLeaoS(leao,jaula);
    }
    
}
