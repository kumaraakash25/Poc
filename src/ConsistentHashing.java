import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private int numberOfReplicas;

    private SortedMap<Integer, String> circle = new TreeMap<>();


    public ConsistentHashing(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(server + i);
            circle.put(hash, server);
        }
    }

    public void removeServer(String server) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(server + i);
            circle.remove(hash);
        }
    }

    public String getServer(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = getHash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private int getHash(String key) {
        // Simulate a simple hash function for demonstration purposes
        return key.hashCode();
    }
}
