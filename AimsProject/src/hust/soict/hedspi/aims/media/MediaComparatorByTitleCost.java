package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {
        if (media1 == null || media2 == null) {
            if (media1 == null && media2 == null)
                return 0;
            if (media1 == null)
                return -1;
            return 1;
        }

        // So sánh theo Title
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());

        if (titleComparison != 0) {
            return titleComparison;
        }

        // so sánh theo Cost

        if (media1.getCost() < media2.getCost()) {
            return -1;
        } else if (media1.getCost() > media2.getCost()) {
            return 1;
        } else {
            return 0;
        }
    }
}
