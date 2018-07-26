## Leetcode 102 Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

## 思路报告：

想自上而下传一个链表，第一考虑到的方法是制作“备忘录”---遍历。那就考虑需要传哪些参数？
因为是一层层的，所以我们就是需要有高度这个参数 --->**这是个规律**

然后就是每一层怎么处理：遇到新的一层就要创建新的list，之前有的就直接取到，然后添加即可
---->**这也是个规律**

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);

        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            ArrayList<Integer> cur_arr = new ArrayList<>();
            cur_arr.add(root.val);
            res.add(cur_arr);
        } else {
             res.get(depth).add(root.val);
        }

        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }
}
