## LeetCode450

作者：韩灵全

版本：2018-02-22


## 题⽬描述
Delete Node in a BST
Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.



## 思路报告
在bst中找到一个点，并且删除它，那么怎么实现呢？
首先找到这个target，这个容易实现，就是和当前node的val比较，选左选右。
重点考虑找到target如何删除？
这就要考虑BST中删除其实需要分两步，一步是找到这个可以替换这个被删除点的点，一步是把这个点
swap过来。
* 第一步：这么找到这个可以替换的点呢？左子树最右的点或者右子树最左的点。

* 第二步：那如何swap呢？有两种方式，一种是指针，一种是val。因为指针涉及到的太多，不好操作，
那就选择val呗。
但是这样swap值其实只是把可以替换的值拿过去替换，原来的位置还是有这个值的，所以我们还需要
递归地去删除这个点。
所以总结起来就是两大步，三小步。


## 需要注意的细节：
1.root的左子树为空，直接把右子树赋给root；
2.deleteNode返回的是清空后的结果，而不是在树上直接操作

代码如下

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val == key) {
            if (root.left == null) {
                root = root.right;
            }else {
                TreeNode target = root.left;
                // find the rightest node of the left subtree
                while(target.right != null) {
                    target = target.right;
                }
                // swap the element
                root.val = target.val;
                //
                root.left = deleteNode(root.left, target.val);
            }
        }
        return root;
    }
}

```


## 套路总结
* 套路1：把问题break到小步骤解决
* 套路2：但凡遇到node.next类型，一定要判断当前node是都为null
