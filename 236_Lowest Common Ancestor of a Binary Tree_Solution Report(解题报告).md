## LeetCode34

作者：韩灵全

版本：2018-02-24


## 题⽬描述
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

## 思路报告
很直接的思路就是，要找到这两个元素，然后再往根节点靠近过，第一次相遇就是解了。
那怎么找到两个元素呢？ --- 遍历呗，前序、后序、还是中序？
<!-- 先考虑依一下 ，自上而下的话，往往是往下传递区间、范围，到叶子节点，正好会有一个子解集，这样的话对找
找最小父亲没有帮助。
那就自下而上，从下面找到，正好还能往上靠近根节点，那就自下而上找元素。 -->

其实这是一道上下结合的题，从下往下找元素，找到元素为上传

当找到元素后，就把改元素往上传递（传递上来的这个东西代表着下面所有的搜索结果）。
那什么时候结束呢？当一个节点的左右子树都传回一个找到的元素的时候，这个root就是最小父亲了。

## 需要注意的细节：
要判断root == q/p， 而不是判断root.val和 == q.val

代码如下

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}

``


## 套路总结
> 套路1：树形结构的题总是涉及root，root.left, root.right ，所以要找到这样一个子结构去处理
。
