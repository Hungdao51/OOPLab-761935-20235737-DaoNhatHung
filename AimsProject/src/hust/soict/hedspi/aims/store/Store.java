package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    // Chỉ quản lý DigitalVideoDisc như yêu cầu Lab03
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc dvd) {
        if (!itemsInStore.contains(dvd)) {
            itemsInStore.add(dvd);
            System.out.println("'" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("'" + dvd.getTitle() + "' is already in the store.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("'" + dvd.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("'" + dvd.getTitle() + "' was not found in the store.");
        }
    }
}