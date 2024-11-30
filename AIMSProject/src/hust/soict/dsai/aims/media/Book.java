package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    // Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost); // Gọi constructor của lớp cha
        this.authors = new ArrayList<>();
    }

    // Thêm tác giả
    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
        } else {
            System.out.println("Author " + author + " already exists in the list.");
        }
    }

    // Xóa tác giả
    public void removeAuthor(String author) {
        if (authors.contains(author)) {
            authors.remove(author);
        } else {
            System.out.println("Author " + author + " is not in the list.");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + String.join(", ", authors) +
                " - Cost: $" + getCost();
    }

    @Override
    public void displayInfo() {
        System.out.println("Book - " + getTitle() + " - " + getCategory() + " - Authors: " + String.join(", ", authors)
                + " - Cost: $" + getCost());
    }
}
