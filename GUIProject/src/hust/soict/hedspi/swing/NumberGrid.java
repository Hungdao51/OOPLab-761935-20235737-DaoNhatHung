package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // 0-9
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 5, 5));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panel) {
        ButtonListener listener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panel.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(listener);
        }

        btnDelete = new JButton("DEL");
        panel.add(btnDelete);
        btnDelete.addActionListener(listener);

        btnNumbers[0] = new JButton("0");
        panel.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(listener);

        btnReset = new JButton("C");
        panel.add(btnReset);
        btnReset.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            String currentText = tfDisplay.getText();

            if (cmd.equals("DEL")) {
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (cmd.equals("C")) {
                tfDisplay.setText("");
            } else {
                tfDisplay.setText(currentText + cmd);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
