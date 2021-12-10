import static java.awt.event.KeyEvent.VK_ESCAPE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ZoologicoBahia extends JFrame implements KeyListener {

    private JLabel label = new JLabel("Listar Leão");
    

    private JMenuBar menuBar = new JMenuBar();
    

    

    

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    public void teclouNumeros(String string) {
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == VK_ESCAPE){
            int selectedOption = JOptionPane.showConfirmDialog(
                this, 
                "Deseja Sair Realmente?", 
                "Atenção",
                JOptionPane.YES_NO_OPTION
            );

            if(selectedOption == JOptionPane.YES_OPTION){
                dispose();
                System.exit(0);
            }
        }
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
        
    }

    public ZoologicoBahia(){
        super("ZOOLANDIA 1.0");

        Container pane1 = this.getContentPane();
        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pane1.setLayout(new GridLayout(2,1));
        pane2.add(label);
       

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,200);
        this.setVisible(true);

        
        setSize(285,480);
        Dimension resVideo = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamForm = getSize();

        setLocation((resVideo.width - tamForm.width)/2, (resVideo.height - tamForm.height)/2);
        setResizable(false);
        setVisible(true);

    }

    
    public static void main(String[] args){
        ZoologicoBahia application = new ZoologicoBahia();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
}

