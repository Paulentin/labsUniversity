package lab4;

import lab2.*;

import javax.swing.*;
import java.awt.event.*;

import static lab4.Main.list;
import static lab4.Main.listModel;
import static java.lang.Integer.parseInt;

public class AddElement extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField ePrice;
    private JComboBox cbInstr;
    String modelName;

    public AddElement(String elName) {
        this.modelName = elName;
        System.out.println(modelName);
        setContentPane(contentPane);
        setModal(true);
        setTitle("Добавить инструмент");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        int price = parseInt(ePrice.getText());

        switch (cbInstr.getSelectedIndex()) {
            case 0:
                Piano p = new Piano();
                p.setModelName(modelName);
                p.price = price;
                list.add(p);
                break;
            case 1:
                Trumpet t = new Trumpet();
                t.setModelName(modelName);
                t.price = price;
                list.add(t);
                break;
            case 2:
                Drum d = new Drum();
                d.setModelName(modelName);
                d.price = price;
                list.add(d);
                break;
            case 3:
                Guitar g = new Guitar();
                g.setModelName(modelName);
                g.price = price;
                list.add(g);
                break;
        }

        Instrument[] data = list.toArray();
        listModel.clear();
        for (int i = 0; i < data.length; i++) {
            listModel.addElement(data[i].toString());
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

}
