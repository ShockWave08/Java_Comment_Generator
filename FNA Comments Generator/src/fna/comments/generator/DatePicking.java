/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fna.comments.generator;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;


/**
 *
 * @author defStrike
 */
public class DatePicking extends javafx.embed.swing.JFXPanel{
    // declaring variables
    private DatePicker date_Picker; // declaring the datePicker JFXComponent
    private LocalDate dateValue;
    private final String pattern = "MM/dd/yy"; // pattern for date figures to display as integers "Month/Day/Year"
    private VBox pane;
    
    // declaring constructor for class to initilize instances of the class
    public DatePicking()
    {
        setPreferredSize(new Dimension(0, 30));
        init();
    }
    
    
    // initializing and setting up components 
    private void init()
    {
        pane = new VBox();
        pane.setBackground(Background.EMPTY);
        pane.setAlignment(Pos.CENTER_LEFT);
        getDate();
        pane.getChildren().addAll(date_Picker);
        Platform.runLater(this::createScene);
    }
    
    
    public void getDate()
    {
        date_Picker = new DatePicker(); // initializing the datepicker component
        date_Picker.setShowWeekNumbers(false);
        //date_Picker.setPromptText(pattern.toLowerCase());
        
        // using anonymous class to convert date to string format from LocalDate format
        StringConverter converter = new StringConverter<LocalDate>() {
            // creating an instance of the DateTimeFormatter 
            DateTimeFormatter datef = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) 
            {
                if (date != null)
                    {
                        return datef.format(date);
                    }
                else
                    {return "";}
            }

            @Override
            public LocalDate fromString(String string) 
            {
                if (string != null && !string.isEmpty())
                    {
                        return LocalDate.parse(string, datef);
                    }
                else
                    {return null;}
                    
            }
        };
        
        
        date_Picker.setOnAction((e) -> {
            try
            {
                dateValue = date_Picker.getValue();
                date_Picker.setConverter(converter);  
                  
            }
            catch(UnsupportedOperationException uoe)
            {
                uoe.printStackTrace();
            }
        });
    }
    
    
    public String getdateConverted()
    {
        return date_Picker.getConverter().toString(dateValue);
    }
    
    
    private void createScene()
    {
        Scene scene = new Scene(pane);
        setScene(scene);
    }
    
    
    public String dateToday() 
    {
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Date today = Calendar.getInstance().getTime();
        String strdate = df.format(today);
        return strdate;
    }
}

//Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
//	at fna.comments.generator.AgentName.setUserName(AgentName.java:34)
//	at fna.comments.generator.FNAFrame.lambda$main$0(FNAFrame.java:52)
//	at fna.comments.generator.FNAFrame$$Lambda$1/1159190947.run(Unknown Source)
//	at java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:311)
//	at java.awt.EventQueue.dispatchEventImpl(EventQueue.java:749)
//	at java.awt.EventQueue.access$500(EventQueue.java:97)
//	at java.awt.EventQueue$3.run(EventQueue.java:702)
//	at java.awt.EventQueue$3.run(EventQueue.java:696)
//	at java.security.AccessController.doPrivileged(Native Method)
//	at java.security.ProtectionDomain$1.doIntersectionPrivilege(ProtectionDomain.java:75)
//	at java.awt.EventQueue.dispatchEvent(EventQueue.java:719)
//	at java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:201)
//	at java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:116)
//	at java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:105)
//	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
//	at java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:93)
//	at java.awt.EventDispatchThread.run(EventDispatchThread.java:82)
