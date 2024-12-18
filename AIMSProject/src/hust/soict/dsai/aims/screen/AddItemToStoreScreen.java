package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected StoreScreen storeScreen;
    protected JTextField tfTitle, tfCategory, tfCost;

    @SuppressWarnings("unused")
    public AddItemToStoreScreen(Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen;

        setTitle("Add Item to Store");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Title:"));
        tfTitle = new JTextField();
        add(tfTitle);

        add(new JLabel("Category:"));
        tfCategory = new JTextField();
        add(tfCategory);

        add(new JLabel("Cost:"));
        tfCost = new JTextField();
        add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addItemToStore());
        add(btnAdd);

        setVisible(true);
    }

    protected abstract void addItemToStore();
}
