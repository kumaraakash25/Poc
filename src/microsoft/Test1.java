package microsoft;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {

/*        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(str);

        int number = scanner.nextInt();
        System.out.println(number);*/
        //searchRelated();
        //mergeIntervals();
        //numberOfIslands();
        serialize();
    }

    private boolean aBeforeB(String s) {

        // If s contains ba :)
        if (s == null) return false;
        if (s.length() == 1) return true;
        // check if all a before b
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }

    private int fairIndexes(int[] A, int[] B) {
        if (A.length != B.length) return -1;
        int[] result = new int[A.length];
        int countR = -1;

        Arrays.fill(result, Integer.MAX_VALUE);
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA = sumA + A[i];
            sumB = sumB + B[i];
            if (sumA == sumB) {
                // fair index
                result[++countR] = i;
            }
        }
        return countR + 1;
    }

    // question 1 : if a is friends with b , b is friends with c and so on , write a program to check
    // if any 2 people are related. Used DFS
    // .Explained the order of complexity.Also explained about how it
    // is a variation of NP [Travelling salesman ]
    static List<Integer>[] list = new ArrayList[4];

    private static int searchRelated() {
        // A B C D
        int[][] array = {
                {0, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}
        };
        // Intention: connectivity
        boolean[][] visited = new boolean[array.length][array[0].length];

        Map<Integer, List<Integer>> result = new HashMap<>();


        List l1 = new ArrayList();
        List l2 = new ArrayList();
        List l3 = new ArrayList();
        List l4 = new ArrayList();

        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        list[3] = l4;


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1 && !visited[i][j]) {
                    // there is a friend here

                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
        return result.size();
    }

    private int dfs(int vertex, boolean[] visited) {
        int count = 1;
        visited[vertex] = true;

        List<Integer> neighbors = list[vertex];
        for (int n : neighbors) {
            if (!visited[n]) {
                count = count + dfs(n, visited);
            }
        }
        return count;
    }


    //  * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // * Output: [[1,6],[8,10],[15,18]]
    //merge intervals
    private static int[][] mergeIntervals() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {9, 18}, {20, 22}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int startIdx = intervals[0][0]; // 1
        int endIdx = intervals[0][1]; // 3

        List<int[]> list = new ArrayList();
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i]; // 2,6    5,9
            if (current[0] < endIdx) {
                endIdx = current[1]; // 9
            } else {
                list.add(new int[]{startIdx, endIdx}); // 1,6
                startIdx = current[0];
                endIdx = current[1];
            }
        }
        list.add(new int[]{startIdx, endIdx});
        System.out.println(list);
        return list.toArray(int[][]::new);
    }

    //find if the target can be got by summing 2 nodes of a BST ; got the solution and was able
    // to provide Order of  complexity also.Did well but was anxious a bit so i would say that i did good not great
    // Given BST of numbers and sum k find two numbers which add up to given sum.
    private void findTarget() {
        // done
    }

    //Number of islands, Number of Islands type problem and follow up on the same to calculate the area of the island
    private static void numberOfIslands() {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int count = 0;
        int area2 = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ++count;
                    area2 = area2 + dfs(grid, i, j);
                }
            }
        }
        System.out.println(count);
        System.out.println(area2);

    }

    private static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + dfs(grid, row - 1, col) + dfs(grid, row + 1, col) + dfs(grid, row, col - 1) + dfs(grid, row, col + 1);
    }

    // Interviewer gave me an input of Strings and asked me to find Top K Elements - this was LLD.
    //Later he asked to extend this same problem to find Top K heavy hitters (like Top K products on the website or Songs on Spotify). This was HLD.
    private static void heavyHitter() {

    }

    // Given wall with two types of brick porus brick(absorb water) and opaque brick(can't absorb water). If it rains return
    // true if water reaches to ground. Water can move to neighbor bricks in all 5 direction due to gravity.
    //[0,0,1,0,0,1]
    //[0,1,0,0,1,0]
    //[0,0,0,1,0,0]
    //[0,0,1,0,0,0]
    //[0,1,0,0,0,0]
    //I solved it using DFS.
    //follow up: Why DFS?
    private Object waterSeep() {
        return null;
    }

    private static void serialize() {
        List<String> list = Arrays.asList("A", "B");
        byte[] result= String.join(",", list).getBytes(StandardCharsets.UTF_8);
        Base64.getEncoder().encodeToString(result);
    }
}
