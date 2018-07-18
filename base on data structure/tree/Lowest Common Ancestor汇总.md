## 474 Lowest Common Ancestor II 题目
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.

```java
public class Solution {
  public ParentTreeNode lca2 (ParentTreeNode root, ParentTreeNode A,  ParentTreeNode B) {
    ParentTreeNode res = root;
    ArrayList<ParentTreeNode> pathA = getPath(A);
    ArrayList<ParentTreeNode> pathB = getPath(B);

    int indexA = pathA.size() - 1;
    int indexB = pathB.size() - 1;

    while (indexA >= 0 && indexB >= 0) {
      if (pathA.get(indexA) != pathB.get(indexB)) {
        break;
      }
      res = pathA.get(indexA);
      indexA--;
      indexB--;
    }

    return res;
  }

  public ArrayList<ParentTreeNode> getPath (ParentTreeNode node) {
    ArrayList<ParentTreeNode> path = new ArrayList<>();

    while (node.parent != null) {
      path.add(node);
      node = node.parent;
    }
    return path;
  }
}
```

##  Lowest Common Ancestor III 题目
node A 和 node B不一定在此颗树里，当没有的时候，返回null

### 解题思路：
**分治是解决二叉树问题的万精油**
由lca1我们有了一种分治算法---看左右子树返回值，来确定lca
但是，当时的前提条件是，我们一定能返回一份非空node（lca或者发现了某个点）
此时，因为两个点可能不在此树里，所以，为了确定lca，我们需要更多的返回值——点A和点B是否存在。所以定义ResultType
```java
class ResultType {
  public boolean a_exist;
  public boolean b_exist;
  public TreeNode lca;
  ResultType(TreeNode lca, boolean a, boolean b) {
    a_exist = a;
    b_exist = b;
    lca = this.lca;
  }
}
public class Soultion {

  public TreeNode lca3 (TreeNode A, TreeNode B,TreeNode root) {
    ResultType rt = helper( A, B, root);
    if (rt.a_exist && rt.b.exist) {
      return rt.lca;
    }
    return null;
  }

  public ResultType helper (TreeNode A, TreeNode B，TreeNode root) {
    if (root == null) {
      return new ResultType(false, false, root);
    }

    ResultType left = helper(root.left, A, B);
    ResultType right = helper(root.right, A, B);

    boolean a_exist = left.a_exist || right.a_exist || root == A;
    boolean b_exist = left.b_exist || right.b_exist || root == B;

    if (root == A || root == B) {
      return new ResultType(a_exist, b_exist, root);
    }
    if (left.lca !== null && right.lca != null) {
      return new ResultType(a_exist, b_exist, root);
    }
    if (left.lca !== null) {
      return new ResultType(a_exist, b_exist, left.lca);
    }
    if (right.lca != null) {
      return new ResultType(a_exist, b_exist, right.lca);
    }

    return new ResultType(a_exist, b_exist, null);
  }
}
```
