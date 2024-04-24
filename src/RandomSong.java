import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomSong {
    public static void main(String[] args) {
        List<String> songs = List.of("A", "B", "C", "D", "E", "F", "G");
        Set<Integer> visited = new HashSet<>();


        if (songs.isEmpty()) throw new IllegalArgumentException();
        for (int count = 0; count < 5; count++) {
            int selection;
            do {
                selection = getRandom(songs.size(), 0);
            } while (visited.contains(selection));
            visited.add(selection);
            System.out.println(songs.get(selection));
        }

    }

    private static int getRandom(int max, int min) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
