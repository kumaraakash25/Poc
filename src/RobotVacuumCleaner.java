import java.util.*;

public class RobotVacuumCleaner {
    static Set<Item> set = new HashSet<>();

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'.', '.', 'X', '.', '.'},
                {'X', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
        };

    }

    public static int solve(char[][] board) {
        Map<String, Boolean> visited = new HashMap<>();
        dfs(board, 0, 0, 0, visited);
        return set.size();
    }

    private static void dfs(char[][] board, int x, int y, int direction, Map<String, Boolean> visited) {
        String key = x + ":" + y + ":" + direction;
        if (visited.containsKey(key)) {
            return;
        }

        //static int[] dir = new int[] {0,1,2,3}; // right, down, left, up
        // Edge case
        if (x == -1 || x == board.length || y == -1 || y == board[0].length) {
            if (x == board.length) {
                // current direction is down
                // You are at the most extrme corner what is the change in x that you could do? move left
                dfs(board, x - 1, y, 2, visited);
            } else if (x == -1) {
                //current direction is up
                // You are at the extrme upper corner, you could go right
                dfs(board, x + 1, y, 0, visited);
            } else if (y == board[0].length) {
                //current direction is right
                // As per me this should be moving up becuase you are at the last
                dfs(board, x, y - 1, 3, visited);
            } else if (y == -1) {
                //current direction is left
                dfs(board, x, y + 1, 1, visited);
            }
            return;
        }

        //static int[] dir = new int[] {0,1,2,3}; // right, down, left, up
        visited.put(key, true);
        if (board[x][y] != 'X') {
            //keep moving in the same direction
            Item item = new Item(x, y);
            set.add(item);
            if (direction == 0) {
                dfs(board, x, y + 1, 0, visited);
            } else if (direction == 1) {
                dfs(board, x + 1, y, 1, visited);
            } else if (direction == 2) {
                dfs(board, x - 1, y, 2, visited);
            } else {
                dfs(board, x - 1, y, 3, visited);
            }
        }
        else {
            //static int[] dir = new int[] {0,1,2,3}; // right, down, left, up
            //Same as edge case : go to prev x,y and change direction
            if(direction==0) {
                dfs(board , x, y-1 , 1, visited);
            }
            else if(direction==1) {
                dfs(board , x-1, y , 2, visited);
            }
            else if(direction==2) {
                dfs(board , x, y+1 , 3, visited);
            }
            else {
                dfs(board , x+1, y , 0, visited);
            }
        }

    }
}

class Item {
    int x;
    int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashcode() {
        return Objects.hashCode(this.x) * Objects.hashCode(this.y);
    }

    public boolean equals(Object obj) {
        Item object = (Item) obj;
        return (this.x == object.x) && (this.y == object.y);
    }
}
