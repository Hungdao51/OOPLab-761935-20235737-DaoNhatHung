package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 120, "Hnam");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 234, "DavidThomson");
        CompactDisc cd1 = new CompactDisc("Thien Ly Oi", "Pop", 15.5f, 50, "Kcm", "Jack");
        CompactDisc cd2 = new CompactDisc("That Girl", "Pop", 12.0f, 60, "Eds", "Ed Sheeran");
        Book book1 = new Book("The Lord of the Rings", "Fantasy", 29.99f);
        book1.addAuthor("J.R.R. Tolkien");

        store.addMedia(dvd1, dvd2, cd1, cd2, book1);

        int choice;
        do {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> viewStore();
                    case 2 -> updateStore();
                    case 3 -> viewCart();
                    case 0 -> System.out.println("Exiting AIMS. Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void viewStore() {
        store.printStore();
        int choice;
        do {
            storeMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> seeMediaDetails();
                    case 2 -> addMediaToCart();
                    case 3 -> playMediaFromStore();
                    case 4 -> viewCart();
                    case 0 -> System.out.println("Returning to main menu.");
                    default -> System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media you want to see details for: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println("--- Media Details ---");
            System.out.println(media.toString());
            System.out.println("---------------------");

            int choice;
            do {
                mediaDetailsMenu();
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1 -> {
                            cart.addMedia(media);
                        }
                        case 2 -> {
                            if (media instanceof Playable) {
                                try {
                                    ((Playable) media).play();
                                } catch (Exception e) {
                                    System.out.println("Error playing media: " + e.getMessage());
                                }
                            } else {
                                System.out.println("'" + media.getTitle() + "' cannot be played.");
                            }
                        }
                        case 0 -> System.out.println("Returning to store menu.");
                        default -> System.out.println("Invalid choice. Please enter a number between 0 and 2.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    choice = -1;
                }
            } while (choice != 0);
        } else {
            System.out.println("Media with title '" + title + "' not found in the store.");
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to your cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media with title '" + title + "' not found in the store.");
        }
    }

    private static void playMediaFromStore() {
        System.out.print("Enter the title of the media from the store to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (Exception e) {
                    System.out.println("Error playing media: " + e.getMessage());
                }
            } else {
                System.out.println("'" + media.getTitle() + "' cannot be played.");
            }
        } else {
            System.out.println("Media with title '" + title + "' not found in the store.");
        }
    }

    private static void updateStore() {
        System.out.println("Update Store Options:");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.print("Please choose an option (1-2): ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addMediaToStore();
                case 2 -> removeMediaFromStore();
                default -> System.out.println("Invalid choice. Returning to main menu.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void addMediaToStore() {
        System.out.println("Select media type to add:");
        System.out.println("1. Digital Video Disc (DVD)");
        System.out.println("2. Compact Disc (CD)");
        System.out.println("3. Book");
        System.out.print("Enter type (1-3): ");
        int typeChoice;
        try {
            typeChoice = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Cost: ");
            float cost = Float.parseFloat(scanner.nextLine());

            Media newMedia = null;

            switch (typeChoice) {
                case 1 -> {
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Length (minutes): ");
                    int length = Integer.parseInt(scanner.nextLine());
                    newMedia = new DigitalVideoDisc(title, category, cost, length, director);
                }
                case 2 -> {
                    System.out.print("Enter Artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter Director (optional, leave blank if none): ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Length (minutes): ");
                    int length = Integer.parseInt(scanner.nextLine());
                    newMedia = new CompactDisc(title, category, cost, length, director, artist);
                }
                case 3 -> {
                    newMedia = new Book(title, category, cost);
                    System.out.print("Enter author(s) (comma-separated): ");
                    String authorsInput = scanner.nextLine();
                    String[] authors = authorsInput.split(",");
                    for (String author : authors) {
                        ((Book) newMedia).addAuthor(author.trim());
                    }
                }
                default -> System.out.println("Invalid media type choice.");
            }

            if (newMedia != null) {
                store.addMedia(newMedia);
                System.out.println("Media added to the store.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for ID, Cost, or Length.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding media: " + e.getMessage());
        }
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove from the store: ");
        String title = scanner.nextLine();
        Media mediaToRemove = store.searchByTitle(title);
        if (mediaToRemove != null) {
            store.removeMedia(mediaToRemove);
            System.out.println("'" + title + "' removed from the store.");
        } else {
            System.out.println("Media with title '" + title + "' not found in the store.");
        }
    }

    private static void viewCart() {
        cart.print();
        cart.totalCost();

        int choice;
        do {
            cartMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> filterCart();
                    case 2 -> sortCart();
                    case 3 -> removeMediaFromCart();
                    case 4 -> playMediaFromCart();
                    case 5 -> placeOrder();
                    case 0 -> System.out.println("Returning to main menu.");
                    default -> System.out.println("Invalid choice. Please enter a number between 0 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void filterCart() {
        System.out.println("Filter cart by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Enter filter option (1-2): ");
        int filterChoice;
        try {
            filterChoice = Integer.parseInt(scanner.nextLine());
            switch (filterChoice) {
                case 1 -> {
                    System.out.print("Enter ID to filter: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    cart.filterMediaByID(id);
                }
                case 2 -> {
                    System.out.print("Enter Title to filter: ");
                    String title = scanner.nextLine();
                    cart.filterMediaByTitle(title);
                }
                default -> System.out.println("Invalid filter option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the filter option or ID.");
        }
    }

    private static void sortCart() {
        System.out.println("Sort cart by:");
        System.out.println("1. Title (then Cost)");
        System.out.println("2. Cost (then Title)");
        System.out.print("Enter sort option (1-2): ");
        int sortChoice;
        try {
            sortChoice = Integer.parseInt(scanner.nextLine());
            switch (sortChoice) {
                case 1 -> cart.sortByTitleCost();
                case 2 -> cart.sortByCostTitle();
                default -> System.out.println("Invalid sort option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the sort option.");
        }
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove from your cart: ");
        String title = scanner.nextLine();
        cart.removeMediaByTitle(title);
    }

    private static void playMediaFromCart() {
        System.out.print("Enter the title of the media from the cart to play: ");
        String title = scanner.nextLine();
        cart.playMedia(title);
    }

    private static void placeOrder() {
        if (cart.getItemsOrdered().isEmpty()) {
            System.out.println("Your cart is empty. Cannot place an order.");
            return;
        }
        System.out.println("--- Order Placed ---");
        cart.print();
        cart.totalCost();
        System.out.println("Thank you for your order!");
        cart.clear();
        System.out.println("Your cart has been emptied.");
    }
}