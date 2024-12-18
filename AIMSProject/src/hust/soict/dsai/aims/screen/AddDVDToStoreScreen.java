package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class AddDVDToStoreScreen extends AddItemToStoreScreen {

    public AddDVDToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        setTitle("Add DVD to Store");
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = JOptionPane.showInputDialog(this, "Enter director:");
            int length = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter length in minutes:"));

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd); // Có thể ném ngoại lệ

            JOptionPane.showMessageDialog(this, "DVD added to store successfully!");
            storeScreen.refreshCenterPanel();
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to add DVD to store!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
