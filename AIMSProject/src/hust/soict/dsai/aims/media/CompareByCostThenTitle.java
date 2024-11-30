package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class CompareByCostThenTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparision = Float.compare(media1.getCost(), media2.getCost());
        if (costComparision != 0) {
            return costComparision;
        }
        // Nếu giá bằng nhau
        return media1.getTitle().compareToIgnoreCase(media2.getTitle());
    }
}
