package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            if (media != null) {
                if (!itemsInStore.contains(media)) {
                    itemsInStore.add(media);
                    System.out.println("'" + media.getTitle() + "' has been added to the store.");
                } else {
                    System.out.println("'" + media.getTitle() + "' is already in the store.");
                }
            } else {
                System.out.println("Error: Cannot add a null item to the store.");
            }
        }
    }

    public void removeMedia(Media media) {
        if (media != null) {
            if (itemsInStore.remove(media)) {

                System.out.println("'" + media.getTitle() + "' has been removed from the store.");
            } else {

                System.out.println("'" + media.getTitle() + "' was not found in the store.");
            }
        } else {
            System.out.println("Error: Cannot remove a null item.");
        }
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }

    public Media searchByTitle(String title) {
        if (title != null && !itemsInStore.isEmpty()) {
            for (Media media : itemsInStore) {
                if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    return media;
                }
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}