package fna.comments.generator;

import javax.swing.JOptionPane;

/**
 *
 * @author defStrike
 */
public class RequestAgentName{
    
    // instance variable daclaration
    private static String uName;
   
    /*
    recursive method set username to instance variable
    */
    
    public void setUserName(String name) throws NullPointerException
    {       
        name = JOptionPane.showInputDialog(null, "Insert First Name and Last Initial", "Agent Name", 
                 JOptionPane.PLAIN_MESSAGE);
        
        if(name == null)
            System.exit(0);
        // if user input is not empty
        if(!name.isEmpty())
        {
            // verify input is acceptable, if yes assign input to global variable
            if(JOptionPane.showConfirmDialog(null, "Is This Your Name?\n\n           " + name, "WARNING" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
            {
                uName = name;
            } // end if 
            
            // if input is not acceptable prompt user to reenter name
            else
                // if username is wrong reenter until correct
                this.setUserName(name);
                 
                
        } // end if
        
            // if input is empty prompt user to reenter 
            else
                this.setUserName(name);
                   
    
    } //end method set username
     
    // method to return user input 
    public String getUserName(){
        return uName;
    } // end method get username 
    
} // end of Request name class


     

