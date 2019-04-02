package fna.comments.generator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author DefStrike
 */

public class FnaComponents extends JPanel implements Runnable
{
    
    // variable declarations
    private final String name;
    
    private JLabel policy_num;
    private JTextField policyNum_Textfield; 
    
    private JToggleButton Go_Shadow; 
    
    private JLabel newbLabel;
    
    private JLabel biLabel;
    private JComboBox bilimButton;
    private JComboBox bicslButton;
    private final String[] bilimits = {"", "No Prior", "Innocent No Prior", "0/0", "10/10", "12.5/25", "15/30", "20/40", "20/50",
                                        "25/50", "25/65", "30/60", "35/70", "50/100", "100/100",  "100/200", "100/300", 
                                        "250/500", "300/500", "500/500", "500/1000"};
    private final String[] bicsl = {"","0", "75", "100", "200", "300", "500", "1000"};
    
    private JLabel lapse_Label;
    private JSpinner lapse_Spinner;
    
    private JButton noChange_Button;
    private JButton change_Button;
    private JButton decrease_Button;
    private JButton increase_Button;
    
    private JButton copy_Button;
    private JButton clear_Button;
    
    private JTextArea output;
    // end of variable declarations
    
    public FnaComponents()
    {
        super(new GridBagLayout());
        
        setPreferredSize(new Dimension(580,430));
        setBackground(Color.white);
        
        RequestAgentName aName = new RequestAgentName();
        name = aName.getUserName();
        
        run();
        
   }
    
    @Override
    public final void run(){
        init();
    }
    
        private void init()
        {
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10,10,10,10);
            
            
            /////////// COLUMN 1//////////////
        
            policy_num = new JLabel("Policy #", SwingConstants.CENTER);
            policy_num.setToolTipText("Paste Policy Number Here");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(policy_num, gbc);
        
            newbLabel = new JLabel("NB Date:", SwingConstants.CENTER);
            newbLabel.setToolTipText("Choose New Business Date");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(newbLabel, gbc);
        
            biLabel = new  JLabel("BI Limits:", SwingConstants.CENTER);
            biLabel.setToolTipText("Choose Insureds BI Limits");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(biLabel, gbc);
        
            lapse_Label = new JLabel("Lapse:", SwingConstants.CENTER);
            lapse_Label.setToolTipText("Choose The Number Of Lapse");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(lapse_Label, gbc);
        
            noChange_Button = new JButton("No Change");
            noChange_Button.setToolTipText("Click this button if insured made no changes to biLimits or tier code");
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(noChange_Button, gbc);
        
            copy_Button = new JButton("Copy");
            copy_Button.setToolTipText("Click To Copy Text From Text Area");
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(copy_Button, gbc);
        
        
            ////////// COLUMN 2 ///////////
        
            policyNum_Textfield = new JTextField(10);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(policyNum_Textfield, gbc);
        
            DatePicking date_Picker = new DatePicking();
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(date_Picker, gbc);
        
            bilimButton = new JComboBox<>(bilimits);
            bilimButton.setToolTipText("Choose BI Limits");
            bilimButton.setEditable(true);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(bilimButton, gbc);

            SpinnerModel spinModel = new SpinnerNumberModel(00, 00, 30, 1);
            lapse_Spinner = new JSpinner(spinModel);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(lapse_Spinner, gbc);

            change_Button = new JButton("Change");
            change_Button.setToolTipText("Click this button if insured has a lapse in coverage");
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.weightx = 0.5;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(change_Button, gbc);
        
        
            //////////////////// COLUMN 3 ///////////////////

            bicslButton = new JComboBox<>(bicsl);
            bicslButton.setToolTipText("Choose comibined single limits");
            bicslButton.setEditable(true);
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.WEST;
            add(bicslButton, gbc);

            decrease_Button = new JButton("Decrease");
            decrease_Button.setToolTipText("Click this button if insured had a decrease in coverage");
            gbc.gridx = 2;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(decrease_Button, gbc);


            ////////////////// COLUMN 4 ////////////////////

            Go_Shadow = new JToggleButton("Hid");
            Go_Shadow.setToolTipText("Click this button to go in shadow mode");
            gbc.gridx = 5;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.EAST;
            add(Go_Shadow, gbc);

            increase_Button = new JButton("Increase");
            increase_Button.setToolTipText("Click this button if insured made an increase in coverage");
            gbc.gridx = 3;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(increase_Button, gbc);

            clear_Button = new JButton("Clear");
            clear_Button.setToolTipText("Click this to clear all textfields");
            gbc.gridx = 3;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            add(clear_Button, gbc);

            
            ///////////////////// TEXT AREA ///////////////////////
            
            Border displayArea_Border = BorderFactory.createLoweredBevelBorder();
            
            output = new JTextArea();
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.weighty = 1;
            gbc.gridwidth = 9;
            gbc.gridheight = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.SOUTHWEST;
            output.setBorder(displayArea_Border);
            output.setEditable(true);
            output.setLineWrap(true);
            output.setWrapStyleWord(true);



            JScrollPane scroll = new JScrollPane(output);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scroll.setPreferredSize(new Dimension(0, 120));
            add(scroll, gbc);

            Go_Shadow.addActionListener((ActionEvent e) -> {
                JFrame window = (JFrame) SwingUtilities.getWindowAncestor(FnaComponents.this);
                Point location = window.getLocation();
                
                    if(Go_Shadow.isSelected()){
                        window.dispose();
                        window.setUndecorated(true);
                        window.setOpacity(0.3f);
                        setOpaque(false);
                        Go_Shadow.setBackground(Color.RED);
                        
                    }
                    else {
                        window.dispose();
                        window.setOpacity(1f);
                        window.setUndecorated(false);
                        Go_Shadow.setBackground(Color.lightGray);
                        setOpaque(true);
                        
                    }
                    window.setLocation(location);
                    window.setVisible(true);
            });
                
        
            
            // adding listeners to components
            // registering all components with their respective listeners
            CompHandler compHandler = new CompHandler(date_Picker);
            noChange_Button.addActionListener(compHandler);
            change_Button.addActionListener(compHandler);
            decrease_Button.addActionListener(compHandler);
            increase_Button.addActionListener(compHandler);
            decrease_Button.addActionListener(compHandler);
            copy_Button.addActionListener(compHandler);
            clear_Button.addActionListener(compHandler);
            
            
        }

        
        /*
            // class to handle text fields
        */
        
        private class CompHandler implements ActionListener
        {
            private final DatePicking date;
            
            
            private String pNum;
            private String newbDate;
            private String biLimit;
            private String lapses;
            private final String change = "See new premium change. ";
            private final String decrease = "See new premium decrease. ";
            private final String increase = "See new premium increase. ";
            private String comment;

            private CompHandler (DatePicking date)
            {
                this.date = date;
            }
            
            
            @Override
            public void actionPerformed(ActionEvent e) throws NullPointerException  
            {
                
                Object button_command = e.getActionCommand();
                

                    if (button_command.equals("Change"))
                    {
                        pNum = policyNum_Textfield.getText();
                        newbDate = date.getdateConverted();
                        biLimit = getBiLimits();
                        lapses = lapse_Spinner.getValue().toString();
                        comment = "(" + date.dateToday() + ") Policy Number (" + pNum + ") validated prior insurance effective (" + newbDate + ") per documentation in Image Center." 
                                             + "Verified prior BI Limits of (" + biLimit + ") with (" + lapses + ") days lapse in coverage. ";
                    
                        output.setText(comment + change + name);
                        output.setFont(new Font("Serif", Font.BOLD, 18));
                        output.setForeground(Color.black);
                    }
                        
                    
                    else if(button_command.equals("No Change"))    
                    {
                        pNum = policyNum_Textfield.getText();
                        newbDate = date.getdateConverted();
                        biLimit = getBiLimits();
                        lapses = lapse_Spinner.getValue().toString(); 
                        comment = "(" + date.dateToday() + ") Policy Number (" + pNum + ") validated prior insurance effective (" + newbDate + ") per documentation in Image Center." 
                                             + "Verified prior BI Limits of (" + biLimit + ") with (" + lapses + ") days lapse in coverage. ";
                        output.setText(comment + name);
                        output.setFont(new Font("Serif", Font.BOLD, 18));
                        output.setForeground(Color.black);
                    }
                       
                    else if(button_command.equals("Decrease"))
                    {
                        pNum = policyNum_Textfield.getText();
                        newbDate = date.getdateConverted();
                        biLimit = getBiLimits();
                        lapses = lapse_Spinner.getValue().toString(); 
                        comment = "(" + date.dateToday() + ") Policy Number (" + pNum + ") validated prior insurance effective (" + newbDate + ") per documentation in Image Center." 
                                             + "Verified prior BI Limits of (" + biLimit + ") with (" + lapses + ") days lapse in coverage. ";
                    
                        output.setText(comment + decrease + name);
                        output.setFont(new Font("Serif", Font.BOLD, 18));
                        output.setForeground(Color.black);
                    }        
                    
                
                    else if (button_command.equals("Increase"))
                    {  
                        pNum = policyNum_Textfield.getText();
                        newbDate = date.getdateConverted();
                        biLimit = getBiLimits();
                        lapses = lapse_Spinner.getValue().toString(); 
                        comment = "(" + date.dateToday() + ") Policy Number (" + pNum + ") validated prior insurance effective (" + newbDate + ") per documentation in Image Center." 
                                             + "Verified prior BI Limits of (" + biLimit + ") with (" + lapses + ") days lapse in coverage. ";
                        output.setText(comment + increase + name);
                        output.setFont(new Font("Serif", Font.BOLD, 18));
                        output.setForeground(Color.black);
                    }  
                
                    else if(button_command.equals("Copy"))
                    {
                        output.selectAll();
                        output.copy();
                    }
                
                    else if(button_command.equals("Clear"))
                    {
                        policyNum_Textfield.setText("");
                        bilimButton.setSelectedIndex(0);
                        bicslButton.setSelectedIndex(0);
                        lapse_Spinner.setValue(00);
                        output.setText(""); 
                        policyNum_Textfield.requestFocus();
                    }
                    
                    userInputHandling();  
                    policy_Number_Contains_Only_Integers(pNum);
            }
            
            private void userInputHandling() throws NullPointerException{
                
                final int two = 2;
                final int eight = 8;
                final int nine = 9;
                
                
                    if (pNum.isEmpty() || pNum == null){
                        output.setText("\n                Missing Insured's Policy Number " + name.substring(0, name.length() - two));
                        output.setFont(new Font("Serif", Font.PLAIN, 20));
                        output.setForeground(Color.red);
                        policyNum_Textfield.requestFocus();
                    }
                    
                    else if(pNum.length() < eight) {
                        output.setText("\n                Policy Number is To Short " + name.substring(0, name.length() - two));
                        output.setFont(new Font("Serif", Font.PLAIN, 20));
                        output.setForeground(Color.red);
                        policyNum_Textfield.requestFocus();
                    }
                    
                    else if(pNum.length() > nine){
                        output.setText("\n                Policy Number is To Long " + name.substring(0, name.length() - two));
                        output.setFont(new Font("Serif", Font.PLAIN, 20));
                        output.setForeground(Color.red);
                        policyNum_Textfield.requestFocus();
                    }
                    
                    
                    else if(newbDate.isEmpty() || newbDate == null){
                        output.setText("\n             Missing Insured's New Business Date " + name.substring(0, name.length() - two));
                        output.setFont(new Font("Serif", Font.PLAIN, 20));
                        output.setForeground(Color.blue); 
                        date.requestFocus();
                    }
                    else 
                        
                        setBiLimits();
                        
                    
                    if((int)lapse_Spinner.getValue() <= nine){
                        lapses = "0" + lapse_Spinner.getValue(); 
                    }
                    
            }    
                        
            
            
            private void policy_Number_Contains_Only_Integers(String policy_Number){
                final int two = 2;
                
                if(policy_Number.matches(".*[A-Za-z].*") == true){
                    output.setText("\n                Policy Number contains letter (s) " + name.substring(0, name.length() - two));
                    output.setFont(new Font("Serif", Font.PLAIN, 20));
                    output.setForeground(Color.red);
                    policyNum_Textfield.requestFocus();
                 }       
            }
            
            private void setBiLimits(){
                final int two = 2;
                
                if(bicslButton.getSelectedItem().toString().isEmpty() && bilimButton.getSelectedItem().toString().isEmpty()){
                    output.setText("\n                  Missing Insured's BI Limits " + name.substring(0, name.length() - two));
                    output.setFont(new Font("Serif", Font.PLAIN, 20));
                    output.setForeground(Color.ORANGE);
                    bilimButton.requestFocus();
                }
                else if(!bicslButton.getSelectedItem().toString().isEmpty() && !bilimButton.getSelectedItem().toString().isEmpty()){
                    output.setText("\n               Insured Can't Have Both Single and CSL BI Limits " + name.substring(0, name.length() - two));
                    output.setFont(new Font("Serif", Font.PLAIN, 20));
                    output.setForeground(Color.ORANGE);
                    bilimButton.requestFocus();
                }
                else if(!bilimButton.getSelectedItem().toString().isEmpty()){
                    biLimit = bilimButton.getSelectedItem().toString();
                }
                else if(!bicslButton.getSelectedItem().toString().isEmpty()){
                    biLimit = bicslButton.getSelectedItem().toString();
                }  
            }
            
            private String getBiLimits(){
                return biLimit;
            }
                  
    } // end component handler class
              
} // end of class FNA Components
    