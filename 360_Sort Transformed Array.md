典型相遇双指针
比较两端大小，不断向内部靠近

```java
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int beg = 0;
        int end = nums.length - 1;
        int i = a >= 0? nums.length - 1 : 0;


        if (a >= 0) {
            while (beg <= end) {
               int temp1 = a * nums[beg] * nums[beg] + b * nums[beg] + c;
               int temp2 = a * nums[end] * nums[end] + b * nums[end] + c;
               if (temp1 >= temp2) {
                res[i--] = temp1;
                beg++;
               } else {
                res[i--] = temp2;
                end--;
             }
            }
        }

         if (a < 0) {
             while (beg <= end) {
             int temp1 = a * nums[beg] * nums[beg] + b * nums[beg] + c;
             int temp2 = a * nums[end] * nums[end] + b * nums[end] + c;
             if (temp1 <= temp2) {
                res[i++] = temp1;
                beg++;
              } else {
                res[i++] = temp2;
                end--;
              }
            }
         }

       return res;
    }

 }
