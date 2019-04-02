/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fna.comments.generator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author defStrike
 */
public class MenuBar extends JMenuBar{
    
    // variable declaration
    private JMenu menu;
    private JMenuItem menuItem;
    private JMenuItem changed_Name;
    private JMenuItem exit;
    
    
    
    public MenuBar(){
        
        init();
       
    }
    
    
    private void init(){
        
        menu = new JMenu("File");
        add(menu);
        
        changed_Name = new JMenuItem("Change Name");
        changed_Name.setMnemonic(KeyEvent.VK_C);
        changed_Name.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
        changed_Name.getAccessibleContext().setAccessibleDescription("This Will Allow a Name Change");
        menu.add(changed_Name);
        
        exit = new JMenuItem("Exit");
        menu.add(exit);
        
        
        menu = new JMenu("Help");
        add(menu);
        
        menuItem = new JMenuItem("Help & Docs");
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED) );
        menuItem.getAccessibleContext().setAccessibleDescription("Get Help or View Software documents");
        menu.add(menuItem);
        
        menuItem = new JMenuItem("About");
        menu.add(menuItem);
        
        MenuHandler menuHandler = new MenuHandler();
        menuItem.addActionListener(menuHandler);
        exit.addActionListener(menuHandler);
        changed_Name.addActionListener(menuHandler);
        
        
    }
    
    
    private class MenuHandler implements ActionListener{
        
        RequestAgentName userName = new RequestAgentName();
        
        @Override
        public void actionPerformed(ActionEvent e) throws UnsupportedOperationException {
            
                Object menuItem_Command = e.getActionCommand();
            
                if(menuItem_Command.equals("Change Name")){
                    userName.setUserName(userName.getUserName());
                }
                else if(menuItem_Command.equals("Exit")){
                    System.exit(0);
                }
 
        }
    
    }
}
