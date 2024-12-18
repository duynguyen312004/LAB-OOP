package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.length > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length + " mins");
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("Track length is non-positive!");
        }
    }
}
