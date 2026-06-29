package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

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
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - " + getDirector()
                + " - " + getLength() + " - " + getCost();
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw new PlayerException("ERROR: Cannot play track " + track.getTitle() + ". " + e.getMessage());
            }
        }
    }

}
