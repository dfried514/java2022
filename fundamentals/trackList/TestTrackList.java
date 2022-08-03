import java.util.HashMap;
import java.util.Set;

public class TestTrackList {
    public static void main(String[] args) {
        TrackList tl = new TrackList();

        HashMap<String, String> tracks = tl.addTracks();

        System.out.println("fire | lyrics: " + tracks.get("fire") + "\n");

        Set<String> keys = tracks.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + tracks.get(key));
        }
    }
}