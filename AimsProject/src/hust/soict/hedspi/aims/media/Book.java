package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }


    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {

        if (authors.contains(authorName)) {
            System.out.println("Author '" + authorName + "' is already in the list.");
        } else {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' has been added to the list.");
        }

    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Author '" + authorName + "' has been removed.");
        } else {
            System.out.println("Author '" + authorName + "' is not presented");
        }

    }
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }
}
