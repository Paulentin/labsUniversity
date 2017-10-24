package lab4;

import lab3.MyListImpl;

import javax.swing.*;
import java.awt.*;

public class ListWindow {
    Panel panel=new Panel();
    JFrame frame=new JFrame();
    private JComboBox comboBox1=new JComboBox();
    private JTextField nameOfInstrumentTextField=new JTextField("fill the name of instrument");
    private JButton addButton=new JButton("Add");
    private JList listOfInstruments=new JList(new MyListImpl().toArray());
    private JButton removeButton=new JButton("REMOVE");
    private JButton clearButton= new JButton("CLEAR");

    ListWindow(){

        panel.add(comboBox1);
        panel.add(nameOfInstrumentTextField, "wrap, pushx, growx");
        panel.add(addButton, "skip, split2");
        panel.add(removeButton, "wrap");
        panel.add(clearButton, "wrap");
        panel.add(listOfInstruments);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListWindow();
            }
        });
    }


}
