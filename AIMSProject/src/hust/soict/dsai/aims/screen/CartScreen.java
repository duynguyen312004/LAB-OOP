package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

@SuppressWarnings("unused")
public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super(); // Gọi constructor của JFrame;
        this.cart = cart;

        // Tạo JFXPanel để nhúng JavaFX vào Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);

        // Chạy JavaFX trên một luồng riêng biệt
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);

                    Parent root = loader.load(); // nạp root node từ FXML
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
