package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        // Tạo danh sách Media
        ArrayList<Media> mediaList = new ArrayList<>();
        try {
            // Thêm DigitalVideoDisc với độ dài hợp lệ
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
            mediaList.add(dvd1);

            // Thêm DigitalVideoDisc với độ dài không hợp lệ
            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Faulty DVD", "Drama", "Unknown Director", 0, 14.99f);
            mediaList.add(dvd2);

            // Thêm CompactDisc (giả sử độ dài hợp lệ)
            CompactDisc cd = new CompactDisc("Top Hits", "Music", 12.99f, "Various Artists", 50, "Music Director");
            mediaList.add(cd);

        } catch (Exception e) {
            System.err.println("Error creating media: " + e.getMessage());
        }

        // Gọi play() cho từng Media và xử lý ngoại lệ
        for (Media media : mediaList) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play(); // Gọi phương thức play()
                } catch (PlayerException e) {
                    System.err.println("Exception occurred while playing media: " + e.getMessage());
                    e.printStackTrace();

                    // Hiển thị Dialog thông báo lỗi
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal Media Length",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Media " + media.getTitle() + " is not playable.");
            }
        }
    }
}
