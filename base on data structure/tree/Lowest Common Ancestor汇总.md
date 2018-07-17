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
