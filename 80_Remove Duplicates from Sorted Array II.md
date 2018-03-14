# 双指针
## 追击双指针
  一般主指针只是傻傻的遍历，所以一般放在for循环中
  从动指针则用于记录，放在for循环之外

  ```java8
  class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int pointer2 = 0;

        for (int pointer1 = 0; pointer1 < nums.length; pointer1++) {
            if (pointer1 < 2 || nums[pointer1] != nums[pointer2 - 2]){
                nums[pointer2] = nums[pointer1];
                pointer2++;
            }
        }
        return pointer2;
    }
}
```
