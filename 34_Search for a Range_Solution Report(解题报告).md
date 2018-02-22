## LeetCode34

作者：韩灵全

版本：2018-02-22


## 题⽬描述
Given an array of integers sorted in ascending order, find the starting and
ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

## 思路报告
找区间嘛， 首先的思路可能就是分两次查找target，一次查找第一次出现，一次找到最后一次出现。
每一次都可以用binary search，其中的细节可以看下面的套路总结。
_*但是，我能不能把这两个子问题合二为一，把他们抽象到一个问题呢？*_
可以，找到比taget小的最后一个数，找到比target+1小的最后一个数。

## 需要注意的细节：
 corner case的控制
1.因为beg返回的值可能是-1， -1 + 1 = 0； 所以我们要保证beg < end 才可以进行index的计算
2.当nums的第一个元素就大于target的时候，直接返回-1；

代码如下

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        int beg = binarySearch(nums, target);
        int end = binarySearch(nums, target + 1);

        if (beg < end) {
        res[0] = beg + 1;
        res[1] = end;
        }
        return res;
    }

    private int binarySearch(int[] nums, int target) {
        if (nums.length == 0 || nums[0] >= target) {
            return -1;
        }
        int beg = 0;
        int end = nums.length - 1;

        while (beg < end) {
            int mid = beg + (end - beg + 1 ) / 2;
                if (nums[mid] < target) {
                    beg = mid;
                } else {
                    end = mid - 1;
                }
        }

        return beg;
    }

}

````


## 套路总结
> 套路1：

    要保证不进入死循环，那么就要保证每一次丢掉的个数必须是大于0的，如何保证呢？首先要根
    据题目，确定我们算法是要怎么处理左、中、右三部分，
     1.如果算法是：按照（左中| 右）的这种处理方式，即end = mid; 和beg = mid + 1；的组合
     我们就要保证右不能为空，这就要求我们在求mid的时候，让右边偏长，
     那么就是mid = left + (right - left) / 2;（leetcode 278）
     2.如果算法是：按照（左| 中右）的这种处理方式，即beg = mid; 和end = mid - 1；的组合
     我们就要保证左不能为空，这就要求我们在求mid的时候，让左边偏长，
     那么就是mid = left + (right - left + 1) / 2;
