package AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = dvd;
            System.out.println(dvd.getTitle() + " has been added.");
            qtyOrdered++;
        } else {
            System.out.println("Cart is full! Cannot add more DVDs.");
        }
    }

    // 14.1 Overloading by differing types of parameter
    public void addDVD(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (dvd != null && qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemOrdered[qtyOrdered] = dvd;
                System.out.println(dvd.getTitle() + " has been added.");
                qtyOrdered++;
            } else if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("Cart is full! Cannot add more DVDs.");
                break;
            }
        }
    }

    // 14.2 Overloading by differing the number of parameters
    public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = dvd1;
            System.out.println(dvd1.getTitle() + " has been added.");
            qtyOrdered++;
        } else {
            System.out.println("Cart is full! Cannot add more DVDs.");
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = dvd2;
            System.out.println(dvd2.getTitle() + " has been added.");
            qtyOrdered++;
        } else {
            System.out.println("Cart is full! Cannot add more DVDs.");
        }
    }

    // 13. Removing items from the cart
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].equals(dvd)) {
                for (int j = i; j < qtyOrdered; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println(dvd.getTitle() + " has been removed.");
                break;
            }
        }
    }

    public void displayCart() {
        float Sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + "." + itemOrdered[i].getTitle());
            Sum += itemOrdered[i].getCost();
        }
        System.out.println("Total: " + Sum);
    }

}
