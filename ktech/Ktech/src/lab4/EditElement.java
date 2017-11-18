package lab4;

import lab2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static lab4.Main.list;
import static lab4.Main.listModel;
import static java.lang.Integer.parseInt;

public class EditElement extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField ePrice;
    private String modelName;
    private JComboBox cbInstr;

    public EditElement(Instrument Instrument, int sIndex) {

        createForm();
        modelName = Instrument.getModelName();
        setContentPane(contentPane);
        setModal(true);
        setTitle("Редактировать инструмент");
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(buttonOK);

        ePrice.setText(""+Instrument.price);

        switch (Instrument.toString()) {
            case "Key instr":
                cbInstr.setSelectedIndex(0);
                break;
            case "Wind instr":
                cbInstr.setSelectedIndex(1);
                break;
            case "Percussion instr":
                cbInstr.setSelectedIndex(2);
                break;
            case "Stringed instr":
                cbInstr.setSelectedIndex(3);
                break;
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(sIndex);
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

    private void createForm(){
        contentPane = new JPanel();
        contentPane.setLayout(
                new com.intellij.uiDesigner.core.GridLayoutManager(
                        2, 1, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(
                new com.intellij.uiDesigner.core.GridLayoutManager(
                        1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(
                panel1,
                new com.intellij.uiDesigner.core.GridConstraints(
                        1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(
                new com.intellij.uiDesigner.core.GridLayoutManager(
                        1, 2, new Insets(5, 5, 5, 5), -1, -1, true, false));
        panel1.add(
                panel2,
                new com.intellij.uiDesigner.core.GridConstraints(
                        0, 0, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));

        buttonOK = new JButton();
        buttonOK.setText("Сохранить");

        panel2.add(buttonOK, new com.intellij.uiDesigner.core.GridConstraints(
                0, 0, 1, 1,
                com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER,
                com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                        | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        buttonCancel = new JButton();
        buttonCancel.setText("Отмена");

        panel2.add(
                buttonCancel,
                new com.intellij.uiDesigner.core.GridConstraints(
                        0, 1, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        final JPanel panel3 = new JPanel();
        panel3.setLayout(
                new com.intellij.uiDesigner.core.GridLayoutManager(
                        2, 2,
                        new Insets(5, 5, 5, 5), -1, -1));
        contentPane.add(
                panel3,
                new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK
                                | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Инструмент");
        panel3.add(label1,
                new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        final JLabel label2 = new JLabel();
        label2.setText("Цена");
        panel3.add(label2,
                new com.intellij.uiDesigner.core.GridConstraints(
                        0, 1, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));

        ePrice = new JTextField();
        panel3.add(ePrice, new com.intellij.uiDesigner.core.GridConstraints(
                1, 1, 1, 1,
                com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST,
                com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW,
                com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                null, null, null, 0, false));

        cbInstr = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Piano");
        defaultComboBoxModel1.addElement("Trumpel");
        defaultComboBoxModel1.addElement("Drum");
        defaultComboBoxModel1.addElement("Guitar");
        cbInstr.setModel(defaultComboBoxModel1);
        panel3.add(cbInstr,
                new com.intellij.uiDesigner.core.GridConstraints(
                        1, 0, 1, 1,
                        com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST,
                        com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW,
                        com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null, 0, false));
    }
    private void onOK(int sIndex) {
        int price = parseInt(ePrice.getText());
        Instrument temp = null;

        switch (cbInstr.getSelectedIndex()) {
            case 0:
                temp = new Piano();
                break;
            case 1:
                temp = new Trumpet();
                break;
            case 2:
                temp = new Drum();
                break;
            case 3:
                temp = new Guitar();
                break;
        }
        temp.price=price;
        temp.setModelName(modelName);
        Instrument[] data = list.toArray();
        data[sIndex] = temp;
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
