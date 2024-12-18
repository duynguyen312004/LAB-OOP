package hust.soict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2, 5, 5)); // Sử dụng GridLayout: 2 hàng, 2 cột, khoảng cách 5px
        add(new Label("Enter a number: "));
        tfInput = new TextField(10); // Ô nhập
        add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Gắn sự kiện cho ô nhập

        add(new Label("Accumulated sum: "));
        tfOutput = new TextField(10); // Ô hiển thị tổng
        tfOutput.setEditable(false); // Chỉ đọc
        add(tfOutput);

        setTitle("AWT Accumulator"); // Đặt tiêu đề
        setSize(350, 120); // Đặt kích thước cửa sổ
        setVisible(true); // Hiển thị giao diện

        // Đóng cửa sổ khi nhấn nút Close
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    // Lớp xử lý sự kiện khi nhấn Enter trong ô nhập
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int number = Integer.parseInt(tfInput.getText());
                sum += number; // Cộng dồn vào tổng
                tfInput.setText(""); // Xóa ô nhập
                tfOutput.setText(String.valueOf(sum)); // Hiển thị tổng
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Phương thức chạy chương trình
    public static void main(String[] args) {
        new AWTAccumulator(); // Tạo giao diện
    }
}
