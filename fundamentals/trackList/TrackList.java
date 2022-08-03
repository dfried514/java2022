import java.util.HashMap;

public class TrackList {
    public HashMap<String, String> addTracks() {
        HashMap<String, String> tracks = new HashMap<String, String>();

        tracks.put("timeless", "careless are the days");
        tracks.put("hot nights", "these are the nights of our youth");
        tracks.put("fire", "the fire in sky burns bright");
        tracks.put("timeless summer", "the days of summer are nearly over");

        return tracks;
    }
}