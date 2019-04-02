package fna.comments.generator;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DefStrike
 */
public class FNAFrame extends JFrame {
    
    public FNAFrame()
    {
        super ("FNA Comments Generator");
        setLayout(new BorderLayout());
        setIcon();
        
        setLocationByPlatform(true);
        setResizable(false);
        
        FnaComponents comps = new FnaComponents();
        add(comps);
        
        MenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar);
        
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    // 
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
                {
                    ex.printStackTrace();
                }
                
                RequestAgentName userName = new RequestAgentName();
                userName.setUserName(userName.getUserName());
                (new Thread(new FnaComponents())).start();
                new FNAFrame();
                 

            }
        });
        
        
   }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
   
}