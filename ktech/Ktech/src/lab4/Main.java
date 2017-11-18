package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import lab2.*;
import lab3.MyListImpl;

public class Main extends JFrame {

    public static DefaultListModel<String> listModel = new DefaultListModel<>();
    public static MyListImpl list = new MyListImpl();

    private JList<String> lElem;
    private JButton bSearch;
    private JButton bAdd;
    private JButton bSort;
    private JButton bDelete;
    private JPanel rootPanel;
    private JButton bEdit;
    private JTextField eText;
    private JButton bReloaded;
    private JButton bClear;

    private Main() {
        setContentPane(rootPanel);
        setVisible(true);
        setTitle("Инструменты");
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(400, 400));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lElem.setModel(listModel);
        reList();

        //добавление++
        bAdd.addActionListener((ActionEvent e) -> {
            AddElement dialog = new AddElement(eText.getText());
            dialog.pack();
            dialog.setVisible(true);
        });

        //редактирование
        bEdit.addActionListener((ActionEvent e) -> {
            if (lElem.getSelectedIndex() != -1) {
                Instrument[] data = list.toArray();
                lab4.EditElement dialog = new lab4.EditElement(data[lElem.getSelectedIndex()], lElem.getSelectedIndex());
                dialog.pack();
                dialog.setVisible(true);
            }
        });

        //сортировка
        bSort.addActionListener((ActionEvent e) -> {
            Instrument[] data = list.toArray();
            Arrays.sort(data);
            listModel.clear();
            for (int i = 0; i < data.length; i++) {
                listModel.addElement(data[i].toString());
            }
        });

        //удаление--
        bDelete.addActionListener((ActionEvent e) -> {
            if (lElem.getSelectedIndex() != -1) {
                Instrument[] data = list.toArray();
                data[lElem.getSelectedIndex()] = null;
                list.clear();
                for (int i = 0; i < data.length; i++) {
                    if (data[i] != null) {
                        list.add(data[i]);
                    }
                }
                reList();
            }
        });

        //очистка++
        bClear.addActionListener((ActionEvent e) -> {
            list.clear();
            reList();
        });

        //обновление++
        bReloaded.addActionListener((ActionEvent e) -> {    //++
            listModel.clear();
            reList();
        });

        //поиск++
        bSearch.addActionListener((ActionEvent e) -> {
            String search = eText.getText();
            listModel.clear();
            if (search.length() > 0) {
                listModel.clear();
                Instrument[] data = list.toArray();
                for (int i = 0; i < data.length; i++) {
                    if (data[i].toString().indexOf(search) >= 0) {
                        listModel.addElement(data[i].toString());
                    }
                }
            }
        });
    }

    private void reList() {
        Instrument[] data = list.toArray();
        listModel.clear();
        for (int i = 0; i < data.length; i++) {
            listModel.addElement(data[i].toString());
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
