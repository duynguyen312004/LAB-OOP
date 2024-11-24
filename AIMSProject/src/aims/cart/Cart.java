package aims.cart;

import aims.disc.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.add(disc);
        System.out.println("The disc has been added.");
    }

    // Add a list of DVDs using an array
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            itemsOrdered.add(disc);
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added");
        }
    }

    // Add two DVDs at once
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        itemsOrdered.add(dvd1);
        System.out.println("The disc \"" + dvd1.getTitle() + "\" has been added");
        itemsOrdered.add(dvd2);
        System.out.println("The disc \"" + dvd2.getTitle() + "\" has been added");
    }

    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.remove(disc)) {
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // Calculate the total cost of DVDs in the cart
    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            total += disc.getCost();
        }
        return total;
    }

    // Display all DVDs in the cart
    public void displayCart() {
        for (DigitalVideoDisc disc : itemsOrdered) {
            disc.displayInfo();
        }
    }

    // Sort DVDs in the cart by title alphabetically
    public void sortByTitle() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc::getTitle)
                .thenComparing(Comparator.comparing(DigitalVideoDisc::getCost).reversed()));
        System.out.println("Cart sorted by title.");
    }

    // Sort DVDs in the cart by cost in descending order
    public void sortByCost() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc::getCost).reversed()
                .thenComparing(DigitalVideoDisc::getTitle));
        System.out.println("Cart sorted by cost.");
    }

    // Search DVDs by title
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for title: " + title);
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.isMatch(title)) {
                System.out.println(disc.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title containing: " + title);
        }
    }

    // Search DVDs by category
    public ArrayList<DigitalVideoDisc> searchByCategory(String category) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getCategory().equalsIgnoreCase(category)) {
                result.add(disc);
            }
        }
        return result;
    }

    // Search DVDs by price range
    public ArrayList<DigitalVideoDisc> searchByPrice(double min, double max) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getCost() >= min && disc.getCost() <= max) {
                result.add(disc);
            }
        }
        return result;
    }

    // Get a random DVD for free as a promotion
    public DigitalVideoDisc getRandomFreeDisc() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty, no free disc available.");
            return null;
        }
        Random rand = new Random();
        DigitalVideoDisc freeDisc = itemsOrdered.get(rand.nextInt(itemsOrdered.size()));
        System.out.println("You get \"" + freeDisc.getTitle() + "\" for free!");
        return freeDisc;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        double totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            DigitalVideoDisc disc = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + disc.toString());
            totalCost += disc.getCost();
        }

        System.out.println("Total cost: $" + totalCost);
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getId() == id) {
                System.out.println("Found: " + disc.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD with ID: " + id);
        }
    }

}