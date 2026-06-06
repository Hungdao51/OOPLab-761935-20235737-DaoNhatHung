package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(int length, String title) {
        this.length = length;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
