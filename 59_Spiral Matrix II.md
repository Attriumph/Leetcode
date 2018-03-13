class Solution {
    public int[][] generateMatrix(int n) {

       int[][] matrix = new int[n][n];
        if(n == 0) {
            return matrix;
        }

        int c1 = 0;
        int c2 = n - 1;
        int r1 = 0;
        int r2 = n - 1;
        int val = 0;

        while (r1 <= r2 && c1 <= c2){
          for (int c = c1; c <= c2; c++ ) {
              matrix[r1][c] = ++val;
          }
         for (int r = r1 + 1; r <= r2; r++) {
              matrix[r][c2] = ++val;
          }

        if (r1 < r2 && c1 < c2 ){
           for (int c = c2 -1; c >= c1; c--){
              matrix[r2][c]= ++val;
             }
           for(int r = r2 - 1; r > r1; r--){
              matrix[r][c1]= ++val;
            }
         }

        r1++;
        r2--;
        c1++;
        c2--;
    }
        return matrix;

    }
}
