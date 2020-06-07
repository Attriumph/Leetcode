## inorder traversal

1.可以用 iteration 的方法：

```java
    public class Solution {
       public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }

            cur = stack.removeFirst();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;

    }
     }
```

2.也可以使用递归方法
递归三要素：

- 函数名
- 出口（停止条件）
- 当前层操作
  1）遍历法

````java
    public class Solution {
      public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();

       traverse(root, res);
       return res;
      }

      private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
          return res;
        }

        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
      }
    }
  ```


2）分治法

  public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();

      if (root == null) {
        return res;
      }
      // divide
      ArrayList<Integer> left = inorderTraversal(root.left);
      ArrayList<Integer> right = inorderTraversal(root.right);

      //merge
      res.addAll(left);
      res.add(root.val)
      res.addAll(right);

      return res;
    }
  }
````
