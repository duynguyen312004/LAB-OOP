package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class AddCDToStoreScreen extends AddItemToStoreScreen {

    public AddCDToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store, storeScreen);
        setTitle("Add CD to Store");
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String artist = JOptionPane.showInputDialog(this, "Enter artist:");

            try {
                CompactDisc cd = new CompactDisc(title, category, cost, artist, 0, "Unknown");
                store.addMedia(cd);
                JOptionPane.showMessageDialog(this, "CD added to store successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            storeScreen.refreshCenterPanel();
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}