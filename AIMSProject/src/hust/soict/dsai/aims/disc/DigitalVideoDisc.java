
package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    private int id;

    private static int nbDigitalVideoDiscs = 0;

    // Constructor
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    // Display information of the DVD
    public void displayInfo() {
        System.out.println("ID:" + id + ", Title: " + title + ", Category: " + category + ", Director: " + director +
                ", Length: " + length + " minutes, Cost: $" + cost);
    }

    // Play demo of the DVD
    public void playDemo() {
        if (length > 0) {
            System.out.println("Playing demo of \"" + title + "\" directed by " + director + ".");
        } else {
            System.out.println("Cannot play demo: \"" + title + "\" has no content.");
        }
    }

    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: $" + cost;
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
