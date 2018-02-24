## LeetCode222

作者：韩灵全

版本：2018-02-23


## 题⽬描述
Given a complete binary tree, count the number of nodes.

## 思路报告
要求CBT的节点个数，首先应该想到perfect binary tree有一个求节点个数的公式--2^h - 1

那我能不能利用一下这个公式呢？

要想利用这个公式，那就要找CBT和perfect binary tree 的关系。

仔细观察会发现，对于CBT上的任何一个节点，它要不左子树为perfect（高度比父亲小1），要不右子树
为perfect（高度比父亲小2）。

1.如果左子树为perfect，那也就是此时的右子树是一个子的CBT，又回到原始问题，太好了，递归解决。

2.如果右子树为perfect，那也就是此时的做左子树是一个字的CBT，又回到原始问题，太好了，递归解决。

然后左子树的节点数、右子树的节点数和根节点自己加起来就是所求的总的节点个数了。

## 需要注意的细节：
1.计算CBT树的高度时，一直到左节点为null，容易写错位while(root.left != null),
这样是错的，应为无形的少算了一行（默认本高度存在了）。

代码如下

```java
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = height(root);
        return countHelper(root, h);


    }

    private int countHelper(TreeNode root, int h) {
        if (root == null) {
            return 0;
        }

        int rightH = height(root.right);
        if (h - rightH == 1) {
            return (1 << (h - 1)) + countHelper(root.right, rightH);
        }
        return (1 << (h - 2)) + countHelper(root.left, h - 1);
    }

    private int height(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

}

```


## 套路总结
* 套路1：2的几次方都用>>或者<<
* 套路2：complete binary tree 就是说最后一层的元素都填在左边
* 套路3：perfect binary tree 的leaf node的个数是 1 << h - 1
