public class RottenOranges {

    public static void main(String[] args) {
        int basket[][] = {
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int rows = basket.length;
        int column = basket[0].length;

        int timeLapse = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                boolean isRottenPosition1 = false;
                boolean isRottenPosition2 = false;
                boolean isRottenPosition3 = false;
                boolean isRottenPosition4 = false;

                if (basket[i][j] == 2) {
                    // mark all adjacent as rotten
                    // Adjacents basket[i-1][j] basket[i+1][j] basket[i][j-1] basket[i][j+1] check if they are 1
                    if (i > 0 && basket[i - 1][j] == 1) {
                        basket[i - 1][j] = 2;
                        isRottenPosition1 = true;
                    }
                    if (i + 1 < rows && basket[i + 1][j] == 1) {
                        basket[i + 1][j] = 2;
                        isRottenPosition2 = true;
                    }
                    if (j < column - 1 && basket[i][j + 1] == 1) {
                        basket[i][j + 1] = 2;
                        isRottenPosition3 = true;
                    }
                    if (j - 1 > 0 && basket[i][j - 1] == 1) {
                        basket[i][j - 1] = 2;
                        isRottenPosition4 = true;
                    }
                }
                if (isRottenPosition1 || isRottenPosition2 || isRottenPosition3 || isRottenPosition4) {
                    timeLapse++;
                }
            }
        }
        System.out.println(timeLapse);


    }
}
