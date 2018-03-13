## 套路总结
* ^= 暗示着强转
* recursion 函数写什么参数，就看我需要什么
* recursion三步走：终止条件，当前层，下一层；
```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (search(board, word,0, i,j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int beg, int i, int j){
        if (beg == word.length()) {
            return true;
        }

        if ( i < 0 || i >= board.length || j <  0 || j >= board[0].length || word.charAt(beg) != board[i][j]) {
            return false;
        }

        board[i][j] ^= 256;
        boolean res = search(board, word, beg + 1, i + 1, j) ||
                      search(board, word, beg + 1, i - 1, j) ||
                      search(board, word, beg + 1, i, j + 1) ||
                      search(board, word, beg + 1, i, j - 1);
        board[i][j] ^= 256;
       return res;
    }
}
```
