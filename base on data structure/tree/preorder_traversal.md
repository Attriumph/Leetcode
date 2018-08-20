## preorder traversal
1.可以用iteration的方法：

```java
    public class Solution {
      public List<Integer> preorderTraversal (TreeNode root) {
          if (root == null) {
            return new ArrayList<Integer>();
          }

          List<Integer> res = new ArrayList<>();
          Deque<TreeNode> stack = new Deque<>();

          stack.addFirst(root);
          while(!stack.isEmpty()) {

            TreeNode cur = stack.removeFirst();
            res.add(cur.val);

            if(cur.right != null) {
              stack.addFirst(cur.right);
            }  

            if(cur.left != null) {
              stack.addFirst(cur.left);
            }
          }

          return res;
      }
     }
```
2.也可以使用递归方法
  递归三要素：
  * 函数名
  * 出口（停止条件）
  * 当前层操作
1）遍历法
````java
    public class Solution {
      public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();

       traverse(root, res);
       return res;
      }

      private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
          return;
        }

        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
      }
    }
  ```


2）分治法

  public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();

      if (root == null) {
        return res;
      }
      // divide
      ArrayList<Integer> left = preorderTraversal(root.left);
      ArrayList<Integer> right = preorderTraversal(root.right);

      //merge
      res.add(root.val);
      res.addAll(left);
      res.addAll(right);

      return res;
    }
  }
