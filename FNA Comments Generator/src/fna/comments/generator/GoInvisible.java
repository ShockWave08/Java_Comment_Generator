/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fna.comments.generator;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Serenity
 */
public class GoInvisible implements MouseListener {
    
     FNAFrame Parentpane = new FNAFrame();
     FnaComponents compPanel = new FnaComponents();
     

    @Override
    public void mouseClicked(MouseEvent e) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Parentpane.setUndecorated(true);
        Parentpane.setOpacity(0.5f);
        compPanel.setOpaque(true);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Parentpane.setUndecorated(false);
        compPanel.setOpaque(false);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
