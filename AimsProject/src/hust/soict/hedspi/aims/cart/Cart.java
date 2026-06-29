package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media... mediaList) {
        if (itemsOrdered.size() + mediaList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("Error: Cannot add " + mediaList.length + " items. Cart capacity limit ("
                    + MAX_NUMBERS_ORDERED + ") exceeded.");
            return;
        }
        for (Media mediaa : mediaList) {
            if (mediaa != null) {
                if (!itemsOrdered.contains(mediaa)) {
                    itemsOrdered.add(mediaa);
                    System.out.println("'" + mediaa.getTitle() + "' has been added to the cart.");
                } else {
                    System.out.println("'" + mediaa.getTitle() + "' is already in the cart.");
                }
            } else {
                System.out.println("Error: Cannot add a null item to the cart.");
            }
        }
    }

    public void addMedia(Media media) {
        if (media != null) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                if (!itemsOrdered.contains(media)) {
                    itemsOrdered.add(media);
                    System.out.println("'" + media.getTitle() + "' has been added to the cart.");
                } else {
                    System.out.println("'" + media.getTitle() + "' is already in the cart.");
                }
            } else {
                System.out.println("Error: Cannot add '" + media.getTitle() + "'. Cart capacity limit ("
                        + MAX_NUMBERS_ORDERED + ") reached.");
            }
        } else {
            System.out.println("Error: Cannot add a null item to the cart.");
        }
    }

    public void removeMedia(Media mediaa) {
        if (mediaa != null) {
            if (itemsOrdered.remove(mediaa)) {
                System.out.println("'" + mediaa.getTitle() + "' has been removed from the cart.");
            } else {
                System.out.println("'" + mediaa.getTitle() + "' was not found in the cart.");
            }
        } else {
            System.out.println("Error: Cannot remove a null item.");
        }
    }

    public void removeMediaByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Title cannot be empty.");
            return;
        }
        Media mediaToRemove = null;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                mediaToRemove = media;
                break;
            }
        }

        if (mediaToRemove != null) {
            removeMedia(mediaToRemove);
        } else {
            System.out.println("Media with title '" + title + "' not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media mediaa : itemsOrdered) {
            total += mediaa.getCost();
        }
        System.out.println("Total cost: " + String.format("%.2f", total) + "$");
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is currently empty.");
        } else {
            System.out.println("Ordered Items:");
            for (int i = 0; i < itemsOrdered.size(); i++) {
                Media media = itemsOrdered.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
        }
        System.out.println("***************************************************");
    }

    public void filterMediaByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Title cannot be empty for filtering.");
            return;
        }
        System.out.println("--- Filtering Cart by Title: '" + title + "' ---");
        boolean found = false;
        String searchTitle = title.trim().toLowerCase();
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(searchTitle)) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found with title containing: '" + title + "'");
        }
        System.out.println("-------------------------------------------");
    }

    public void filterMediaByID(int id) {
        System.out.println("--- Filtering Cart by ID: '" + id + "' ---");
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No items found with ID: '" + id + "'");
        }
        System.out.println("-------------------------------------------");
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST_C = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE_C = new MediaComparatorByCostTitle();

    public void sortByTitleCost() {
        System.out.println("--- Sorting Cart by Title (then Cost) ---");
        ArrayList<Media> sortedItems = new ArrayList<>(itemsOrdered);

        Collections.sort(sortedItems, COMPARE_BY_TITLE_COST_C);

        printSortedList(sortedItems);
        System.out.println("-------------------------------------------");
    }

    public void sortByCostTitle() {
        System.out.println("--- Sorting Cart by Cost (then Title) ---");
        ArrayList<Media> sortedItems = new ArrayList<>(itemsOrdered);

        Collections.sort(sortedItems, COMPARE_BY_COST_TITLE_C);

        printSortedList(sortedItems);
        System.out.println("-------------------------------------------");
    }

    private void printSortedList(ArrayList<Media> listToPrint) {
        if (listToPrint.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < listToPrint.size(); i++) {
                System.out.println((i + 1) + ". " + listToPrint.get(i).toString());
            }
        }
    }

    public void playMedia(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Title cannot be empty for playing.");
            return;
        }
        Media mediaToPlay = null;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                mediaToPlay = media;
                break;
            }
        }

        if (mediaToPlay != null) {
            if (mediaToPlay instanceof Playable) {
                try {
                    System.out.println("Playing: '" + mediaToPlay.getTitle() + "'");
                    ((Playable) mediaToPlay).play();
                } catch (Exception e) {
                    System.out.println("Error playing '" + mediaToPlay.getTitle() + "': " + e.getMessage());
                }
            } else {
                System.out.println("'" + mediaToPlay.getTitle() + "' cannot be played.");
            }
        } else {
            System.out.println("Media with title '" + title + "' not found in the cart or cannot be played.");
        }
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}