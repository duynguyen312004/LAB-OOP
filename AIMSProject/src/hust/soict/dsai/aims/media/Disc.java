package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length; // Độ dài của đĩa (tính bằng phút)
    private String director; // Đạo diễn

    // Constructor
    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost); // Gọi constructor của lớp cha (Media)
        this.length = length;
        this.director = director;
    }

    // Getter và Setter
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Hiển thị thông tin chung cho đĩa (DigitalVideoDisc và CompactDisc sẽ kế thừa
    // phương thức này)
    @Override
    public void displayInfo() {
        System.out.println("Disc - " + getTitle() + " - " + getCategory() + " - Director: " + director
                + " - Length: " + length + " mins - Cost: $" + getCost());
    }
}
