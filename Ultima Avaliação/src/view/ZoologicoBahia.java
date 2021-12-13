
// Importando as bibliotecas padrões e as packages.
package src.view;
import javax.swing.*;
import src.model.Golfinho;
import src.model.Jaula;
import src.model.Leao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// Criando o programa principal do sistema.
public class ZoologicoBahia extends JFrame {
    /// Encapsulando os atributos
    private JButton listarLeao;
    private JButton cadastrarLeao;
    private JButton atualizarLeao;
    private JButton deletarLeao;
    private JButton listarGolfinho;
    private JButton cadastrarGolfinho;
    private JButton atualizarGolfinho;
    private JButton deletarGolfinho;
    
    // Criando o construtor do programa principal
    public ZoologicoBahia(){
        super("ZOOLANDIA 1.0");

        // Criando os botões, as label e os tratamentos de eventos.
        JButton button1 = new JButton("Listar Leão");
        JButton button2 = new JButton("Cadastrar Leão");
        JButton button3 = new JButton("Atualizar Leão");
        JButton button4 = new JButton("Deletar Leão");
        JButton button5 = new JButton("Listar Golfinho");
        JButton button6 = new JButton("Cadastrar Golfinho");
        JButton button7 = new JButton("Atualizar Golfinho");
        JButton button8 = new JButton("Deletar Golfinho");

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
        pane.setLayout(null);

        button1.setBounds(10,30,200,22);
        button2.setBounds(10,50,200,22);
        button3.setBounds(10,70,200,22);
        button4.setBounds(10,90,200,22);
        button5.setBounds(10,110,200,22);
        button6.setBounds(10,130,200,22);
        button7.setBounds(10,150,200,22);
        button8.setBounds(10,170,200,22);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ListarLeao();
            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CadastrarLeao();
            }    
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AlterarLeao();
            }    
        });

        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ExcluirLeao();
            }    
        });

        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ListarGolfinho();
            }    
        });

        button6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CadastrarGolfinho();
            }    
        });

        button7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AlterarGolfinho();
            }    
        });

        button8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ExcluirGolfinho();
            }    
        });


        this.setSize(300,310);
        this.setContentPane(pane);
        this.setVisible(true);
    }
 
    // A main do programa principal
    public static void main(String[] args){
        ZoologicoBahia zoolandia = new ZoologicoBahia();
        
        
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        int id = 0;
        String nome = "";
        int treinamento = 0;
        int idJaula = 0;
        String descricao = "";
        int alimentacao = 0;
        int visitantes = 0;
        //Criando os menus de escolha do Crud do Leão e do Golfinho e informações das padarias, mercados e receitas
        do {
            System.out.println("Sistema de cadastro geral e acesso ao ZOOLOGICO BAHIA: ");
            System.out.println("\n");
            System.out.println("Crud de Leão: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. Listar Leão");
            System.out.println("2. Cadastrar Leão");
            System.out.println("3. Atualizar Leão");
            System.out.println("4. Deletar Leão");
            System.out.println("\n");
            System.out.println("Crud de Golfinho: ");
            System.out.println("Digite a opção desejada: ");
            System.out.println("5. Listar Golfinho");
            System.out.println("6.  Cadastrar Golfinho");
            System.out.println("7. Atualizar Golfinho");
            System.out.println("8. Deletar Golfinho");
            System.out.println("\n");
            try{
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            //Chamando os metodos da escolha do menu apartir do cases da chave Switch menu.    
            }
            switch (menu) {
                case 1:
                    try {
                        Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula);
                        ListarLeao.selectLeao(leao);
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.println("\n Nome: ");
                        nome = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade maxima de visitantes: ");
                        visitantes = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Alimento por dia: ");
                        alimentacao = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição: ");
                        descricao = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    try{
                        Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula);
                        Jaula jaula = new Jaula(idJaula, descricao);
                        CadastrarLeao.insertLeao(leao,jaula); 
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("\n Id do leão que deseja editar ");
                        id = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        AlterarLeao.selectLeao(id);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Nome: ");
                        nome = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade maxima de visitantes: ");
                        visitantes = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Alimento por dia: ");
                        alimentacao = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        Leao leao = new Leao(id, nome, alimentacao, visitantes, idJaula);
                        Jaula jaula = new Jaula(idJaula, descricao);
                        AlterarLeao.updateLeao(leao, jaula);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try{
                        System.out.println("\n Informe o id do leão que deseja excluir! ");
                        id = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try{
                        ExcluirLeao.deleteLeao(id);
                       
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try{
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula);
                        ListarGolfinho.selectGolfinho(golfinho);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try{
                        System.out.println("\n Nome: ");
                        nome = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Treinamento: ");
                        treinamento = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Descrição: ");
                        descricao = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    // Vai chamar o metodo para realizar o cadastro do golfinho
                    try{
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula);
                        Jaula jaula = new Jaula(idJaula, descricao);
                        CadastrarGolfinho.insertGolfinho(golfinho, jaula);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        System.out.println("\n Id do golfinho que deseja editar ");
                        id = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        AlterarGolfinho.selectGolfinho(id);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Nome: ");
                        nome = scanner.next();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        System.out.println("\n Quantidade de Treinamento: ");
                        treinamento = scanner.nextInt();
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    try{
                        Jaula jaula = new Jaula(idJaula, descricao);
                        Golfinho golfinho = new Golfinho(id, nome, treinamento, idJaula);
                        AlterarGolfinho.updateGolfinho(golfinho, jaula);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                case 8:
                    try{
                        System.out.println("\n Informe o id do Golfinho que deseja excluir! ");
                        id = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try{
                        ExcluirGolfinho.deleteGolfinho(id);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }            
                    default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
        scanner.close();
    }
}
