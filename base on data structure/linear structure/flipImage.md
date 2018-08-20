```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            throw new IllegalArgumentException("A is null");
        }

        for (int i = 0; i < A.length; i++) {
            flip(A[i]);
            invert(A[i]);
        }

        return A;
    }

    private void flip(int[] arr) {
        int beg = 0;
        int end = arr.length - 1;

        while (beg <= end) {
            int temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;

            beg++;
            end--;
        }
    }

    private void invert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == 0) {
            arr[i] = 1;
          } else {
            arr[i] = 0;
         }
        }

    }
}




class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            throw new IllegalArgumentException("A is null");
        }

        int n = A.length;

        for (int[] cur: A) {
            for (int i = 0; 2 * i < n; ++i) {
                if (cur[i] == cur[n - i - 1]) {
                    cur[i] = cur[n - i - 1] ^= 1;
                }
            }
        }

        return A;
    }
}
