package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media mediaa, Media mediab) {
        if (mediaa == null || mediab == null) {
            if (mediaa == null && mediab == null)
                return 0;
            if (mediaa == null)
                return -1;
            return 1;
        }

        // So sánh theo Cost
        if (mediaa.getCost() < mediab.getCost()) {
            return -1;
        } else if (mediaa.getCost() > mediab.getCost()) {
            return 1;
        }
        int titleComparison = mediaa.getTitle().compareTo(mediab.getTitle());
        return titleComparison;

    }
}