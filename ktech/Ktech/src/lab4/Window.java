package lab4;


import lab2.*;
import lab3.MyListImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Window {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    static ListWindow listWindow=new ListWindow();

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
//        JComboBox<Instrument> instrumentJComboBox=listWindow.getComboBox();
//        fillInCombo(instrumentJComboBox);
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
            frame.setVisible(true);


    }
    private static void fillInCombo(JComboBox<Instrument> combo){

       MyListImpl list = Orchestra.getOrchestra();
       Iterator<Instrument> iter=list.iterator();
       while (iter.hasNext()){
           combo.add(new Component() {
               @Override
               public void setName(String s) {
                   super.setName(iter.next().toString());
               }
           });
       }
    }





    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
