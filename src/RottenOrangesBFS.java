import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesBFS {

    public final static int R = 3;
    public final static int C = 5;

    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }

    private static boolean isCellValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    private static boolean isCellDelimeter(Element element) {
        return element.x == -1 && element.y == -1;
    }

    private static boolean checkFreshOrangeRemaining(int[][] arr) {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    private static int rotOranges(int[][] arr) {
        Queue<Element> Q = new LinkedList<>();
        int answer = 0;
        Element temp;
        // Store all cells having rotten oranges in first time frame
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Element(i, j));

        // This has all rotten, spearate by a time fgrame
        Q.add(new Element(-1, -1));

        while (!Q.isEmpty()) {
            boolean flag = false;
            while (!isCellDelimeter(Q.peek())) {
                temp = Q.peek();
                // Check if right side can be rotten
                if (isCellValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        answer++;
                        flag = true;
                    }
                    arr[temp.x + 1][temp.y] = 2;
                    Q.add(new Element(temp.x + 1, temp.y));
                }

                // Check on the left side
                if (isCellValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        answer++;
                        flag = true;
                    }
                    arr[temp.x - 1][temp.y] = 2;
                    Q.add(new Element(temp.x - 1, temp.y));
                }

                // Check on the top side
                if (isCellValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        answer++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    Q.add(new Element(temp.x, temp.y - 1));
                }

                // Bottom side
                if (isCellValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        answer++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    Q.add(new Element(temp.x, temp.y));
                }

                Q.remove();
            }
            Q.remove(); // It removes the delimeter

            if (!Q.isEmpty()) {
                Q.add(new Element(-1, -1));
            }
        }
        return checkFreshOrangeRemaining(arr) ? -1 : answer;
    }
}

class Element {
    int x = 0;
    int y = 0;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }
}