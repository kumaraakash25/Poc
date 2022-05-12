public class IslandsIn2DArray {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        // 1 is land 0 is water
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    calculateIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("Islands " + count);
    }


    private static void calculateIsland(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j] || arr[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        calculateIsland(arr, i - 1, j, visited);
        calculateIsland(arr, i + 1, j, visited);
        calculateIsland(arr, i, j - 1, visited);
        calculateIsland(arr, i, j + 1, visited);
    }
}