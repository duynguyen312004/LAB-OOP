package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class CompareByTitleThenCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        // So sanh tieu de
        int titleComparision = media1.getTitle().compareToIgnoreCase(media2.getTitle());
        if (titleComparision != 0) {
            return titleComparision;
        }
        // Nếu tiêu đề giống nhau
        return Float.compare(media1.getCost(), media2.getCost());// Đảo ngược để sắp xếp giảm dần
    }
}
