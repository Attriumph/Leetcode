class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;;
        root.left.right = root;

        root.left = null;//once we form a part of  new tree ,we need to destroy orignal tree of this part
        root.right = null;//

        return newRoot;
    }
}
