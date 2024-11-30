package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    // Constructor
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Gọi constructor của lớp cha
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        // Phát DVD
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " mins");
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - Director: " + getDirector() +
                " - Length: " + getLength() + " mins - Cost: $" + getCost();
    }

    @Override
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) other;
            int titleComparision = this.getTitle().compareToIgnoreCase(dvd.getTitle());
            if (titleComparision != 0) {
                return titleComparision;
            }
            // so sánh độ dài
            int lengthComparision = Integer.compare(dvd.getLength(), this.getLength());
            if (lengthComparision != 0)
                return lengthComparision;
            // so sánh giá
            return Float.compare(dvd.getCost(), this.getCost());
        }
        return 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD - " + getTitle() + " - " + getCategory() + " - Director: " + director
                + " - Length: " + length + " mins - Cost: $" + getCost());
    }
}
