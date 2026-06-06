package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private final int length;
    private final String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
}
