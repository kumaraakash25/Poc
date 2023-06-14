package graphs;

public class IslandQuestion {

    // Find the number of island in this
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        int occ = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    // this is a standalone island
                    occ++;
                    // make all adjoining land pieces into 1 unit
                    dfs(i, j, arr);
                }
            }
        }
        System.out.println(occ);
    }

    static void dfs(int i, int j, int[][] arr) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length-1) return;
        if (arr[i][j] == 0) return;

        arr[i][j] = 0;

        dfs(i - 1, j, arr);
        dfs(i + 1, j, arr);
        dfs(i, j - 1, arr);
        dfs(i, j + 1, arr);

    }
}
