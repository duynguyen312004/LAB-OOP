package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist; // Nghệ sĩ
    private ArrayList<Track> tracks; // Danh sách bài hát

    // Constructor
    public CompactDisc(String title, String category, float cost, String artist, int length, String director) {
        super(title, category, cost, length, director); // Gọi constructor của lớp cha (Disc)
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm bài hát vào CD
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " already exists in the CD.");
        }
    }

    // Xóa bài hát khỏi CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the CD.");
        }
    }

    // Tính tổng độ dài của CD (tính tổng độ dài của tất cả các track)
    public int getTotalLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CompactDisc: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("CD length: " + getTotalLength() + " mins");

        // Phát tất cả các bài hát
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - Artist: " + getArtist() +
                " - Director: " + getDirector() + " - Total Length: " + getTotalLength() + " mins - Cost: $"
                + getCost();
    }

    // Hiển thị thông tin của CD
    @Override
    public void displayInfo() {
        System.out.println("CompactDisc - " + getTitle() + " - " + getCategory() + " - Artist: " + artist
                + " - Director: " + getDirector() + " - Total Length: " + getTotalLength() + " mins - Cost: $"
                + getCost());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println("\t" + track.toString());
        }
    }
}