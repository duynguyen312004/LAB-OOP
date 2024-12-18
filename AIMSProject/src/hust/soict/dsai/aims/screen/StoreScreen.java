package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store, this);
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCDToStoreScreen(store, this);
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDVDToStoreScreen(store, this);
        });
        smUpdateStore.add(addDVDItem);

        optionsMenu.add(smUpdateStore);

        JMenuItem viewCartItem = new JMenuItem("View Cart");
        viewCartItem.addActionListener(e -> {
            new CartScreen(cart);
        });
        optionsMenu.add(viewCartItem);

        menuBar.add(optionsMenu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Welcome to AIMS Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 24));
        title.setAlignmentX(CENTER_ALIGNMENT);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10)); // Lưới 3x3 cho các mặt hàng
        store.getItemsInStore().forEach(media -> {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        });
        return center;
    }

    public void refreshCenterPanel() {
        getContentPane().removeAll();
        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        new StoreScreen(store, cart);
    }
}