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
```java
class ResultType {
  public boolean a_exist;
  public boolean b_exist;
  public TreeNode lca;
  ResultType(boolean a, boolean b, TreeNode lca) {
    a_exist = a;
    b_exist = b;
    lca = this.lca;
  }
}
public class Soultion {

  public TreeNode lca3 (TreeNode root, TreeNode A, TreeNode B) {
    ResultType rt = helper(root, A, B);
    if (rt.a_exist && rt.b.exist) {
      return rt.lca;
    }
    return null;
  }

  public ResultType helper (TreeNode root, TreeNode A, TreeNode B) {
    if (root == null) {
      return new ResultType(root, false, false);
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
