## 套路总结：
1. 四向搜索的技巧，用for循环代理hard code
2.只要是四向搜索，就要主要边界条件的限制
3. DFS的优化除了cache，染色，还可以预处理
4.布尔值可以巧用为"标志""
```java
class Solution {
    int row;
    int col;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0, 1,-1};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
            return matrix;
        }

        row = matrix.length;
        col = matrix[0].length;
        preprecess(matrix);

        for (int i = 0;i < row;i++){
            for (int j = 0; j <  col; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix,1, i, j);
                }
            }
        }

        return matrix;
    }

    private void preprecess(int[][] matrix) {
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                boolean border = false;
                for(int k = 0; k < 4; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || x >=row || y < 0 || y >= col) {
                        continue;
                    }
                    border |= matrix[x][y] == 0;
                }
                if (!border) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private void dfs(int[][] matrix, int dis, int x, int y){
        if(matrix[x][y] < dis) {
            return;
        }
        if (matrix[x][y] == dis && matrix[x][y] != 1){// we do not return if it is border
            return;
        }

        matrix[x][y] = dis;

        for (int i = 0; i < 4; ++i){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0|| nextX >= row || nextY <0 || nextY >= col) {
                continue;
            }
            dfs(matrix, dis + 1, nextX, nextY);
        }
    }
}
```
