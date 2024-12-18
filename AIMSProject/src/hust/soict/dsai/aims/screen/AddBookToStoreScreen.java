package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        setTitle("Add Book to Store");
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(title, category, cost);
            store.addMedia(book); // Có thể ném ngoại lệ

            JOptionPane.showMessageDialog(this, "Book added to store successfully!");
            storeScreen.refreshCenterPanel();
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to add book to store!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}