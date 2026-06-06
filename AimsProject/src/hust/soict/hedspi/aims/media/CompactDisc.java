package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final String artist;
    private final ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    // thêm track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' has been added to the CD.");
        }
    }

    // xóa track
    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track '" + track.getTitle() + "' has been removed from the CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' is not found in the CD.");
        }
    }

    public int Lengths() {
        int sumLength = 0;
        if (tracks != null) {
            for (Track track : tracks) {
                sumLength += track.getLength();
            }
        }
        return sumLength;
    }
    public String toString() {
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getDirector() + " - " + getLength() + " - " + getCost();
    }
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Tracks:");

        if (tracks != null) {
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("No tracks on this CD.");
        }
    }

}
