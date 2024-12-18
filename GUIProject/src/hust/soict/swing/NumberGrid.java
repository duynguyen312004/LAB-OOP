package hust.soict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JTextField tfDisplay;
    private JButton[] btnNumbers;
    private JButton btnDelete, btnReset;

    public NumberGrid() {
        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3));

        btnNumbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(new ButtonListener());
        }

        btnDelete = new JButton("DEL");
        btnReset = new JButton("C");
        panelButtons.add(btnDelete);
        panelButtons.add(btnReset);

        btnDelete.addActionListener(new ButtonListener());
        btnReset.addActionListener(new ButtonListener());
        add(panelButtons, BorderLayout.CENTER);
        setVisible(true);
    }

    // Lớp lắng nghe sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            if (source == btnDelete) {
                // Xóa ký tự cuối cùng
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (source == btnReset) {
                // Xóa toàn bộ
                tfDisplay.setText("");
            } else {
                // Nút số: thêm ký tự vào cuối
                tfDisplay.setText(tfDisplay.getText() + source.getText());
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
