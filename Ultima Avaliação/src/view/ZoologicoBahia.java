package src.view;

import java.awt.*;
import javax.swing.*;

public class ZoologicoBahia extends JFrame {

    private JButton listarLeao;
    private JButton cadastrarLeao;
    private JButton atualizarLeao;
    private JButton deletarLeao;
    private JButton listarGolfinho;
    private JButton cadastrarGolfinho;
    private JButton atualizarGolfinho;
    private JButton deletarGolfinho;
    
    JButton button1 = new JButton("Listar Leão");
    JButton button2 = new JButton("Cadastrar Leão");
    JButton button3 = new JButton("Atualizar Leão");
    JButton button4 = new JButton("Deletar Leão");
    JButton button5 = new JButton("Listar Golfinho");
    JButton button6 = new JButton("Cadastrar Golfinho");
    JButton button7 = new JButton("Atualizar Golfinho");
    JButton button8 = new JButton("Deletar Golfinho");

    public ZoologicoBahia() {
        
        listarLeao = new JButton("Mensagem");
        cadastrarLeao = new JButton("Fechar");
        atualizarLeao = new JButton("Mensagem");
        deletarLeao = new JButton("Fechar");
        listarGolfinho = new JButton("Mensagem");
        cadastrarGolfinho = new JButton("Fechar");
        atualizarGolfinho = new JButton("Mensagem");
        deletarGolfinho = new JButton("Fechar");

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(button1);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);
        pane.add(button5);
        pane.add(button6);
        pane.add(button7);
        pane.add(button8);

                

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,300);
        this.setVisible(true);
    }

    public static void main(String[] args){
        ZoologicoBahia janela = new ZoologicoBahia();
    }
}

