## Minimum  Subtree
### 题目思路：
  分治和遍历结合---为什么这样？
  * 因为分治可以我们方便的拿到每个子树的sum
  * traverse方便让我们全局记录一个最小值和一个返回值
  
```java
class Solution {
  public TreeNode findMinTree (TreeNode root) {
     TreeNode res = root;
     int minSum = Integer.MAX_VALUE;
     treeSum(root, minSum, res);
     return res;    
  }
  public int treeSum (TreeNode root, int minSum, TreeNode res) {
    if (root == null) {
      return 0;
    }

    int sum = treeSum(root.left) + treeSum(root.right) + root.val;

    if (sum < minSum) {
      minSum = sum;
      res = root;
    }

    return sum;
  }
}
```
