package hust.soict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField inputField;
    private JTextField sumField;
    private int sum = 0;

    public SwingAccumulator() {
        // Thiet lap JFrame
        setTitle("Swing Accumulator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));

        add(new JLabel("Enter a number: "));
        inputField = new JTextField();
        add(inputField);

        add(new JLabel("Accumulated sum: "));
        sumField = new JTextField("0");
        sumField.setEditable(false);
        add(sumField);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    sum += number;
                    sumField.setText(String.valueOf(sum));
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingAccumulator.this, "Please enter a valid number!",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAccumulator());
    }
}
