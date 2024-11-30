package hust.soict.dsai.aims.media;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    private static int nbMedia = 0; // Đếm số lượng đối tượng Media đã được tạo

    // Constructor
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedia++;
        this.id = nbMedia; // Gán ID tự động
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Phương thức trừu tượng hiển thị thông tin
    public abstract void displayInfo();

    @Override
    public String toString() {
        return "Media [Title: " + title + ", Category: " + category + ", Cost: $" + cost + "]";
    }

    @Override
    public int compareTo(Media other) {
        // So sánh tiêu đề
        int titleComparision = this.title.compareToIgnoreCase(other.title);
        if (titleComparision != 0) {
            return titleComparision;
        }

        // Nếu tiêu đề giống nhau, so sánh theo giá
        return Float.compare(other.cost, this.cost); // Đảo ngược để sắp xếp giảm dần
    }

    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem obj có phải là một instance của Media không
        if (obj instanceof Media) {
            Media other = (Media) obj; // Ép kiểu obj sang Media
            // So sánh title
            return this.title.equalsIgnoreCase(other.getTitle());
        }
        return false; // Trả về false nếu obj không phải là Media
    }
}
