package leaderboard;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Leaderboard {
    private int k; // this is the top k elements
    private HashMap<String, Integer> map;
    private PriorityQueue<Player> minHeap;

    public void LeaderBoard(int k) {
        this.k = k;
        this.map = new HashMap<>();
        this.minHeap = new PriorityQueue<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o1.score, o2.score);
            }
        }); // this creates a min heap.
        // Why are you doing a min heap because on polling you can get rid of the smallest elements
    }

    public void set(String player, int score) {
        // Update the player's score in HashMap
        map.put(player, map.getOrDefault(player, 0) + score);

        // Remove the player from the heap
        PriorityQueue<Player> temp = new PriorityQueue<>((a, b) -> Integer.compare(a.score, b.score));
        while (!minHeap.isEmpty()) {
            Player node = minHeap.poll();
            if (!node.name.equals(player)) {
                temp.add(node);
            }
        }
        minHeap = temp;

        // Add the player's new score to the heap
        minHeap.add(new Player(player, map.get(player)));

        // If heap exceeds size k, remove the minimum element
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public PriorityQueue<Player> getTopK() {
        return new PriorityQueue<>(minHeap);  // Return a copy of the heap
    }


}
