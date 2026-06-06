package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public static void sortByTitleCost(ArrayList<Media> mediaList) {
        Collections.sort(mediaList, COMPARE_BY_TITLE_COST);
    }

    public static void sortByCostTitle(ArrayList<Media> mediaList) {
        Collections.sort(mediaList, COMPARE_BY_COST_TITLE);
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
}
