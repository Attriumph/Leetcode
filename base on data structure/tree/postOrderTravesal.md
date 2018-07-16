## post order traversal
### 1.relation with pre order traversal
  the order for pre-order is **root-left-right**

the order for post-order is **left-right-root**

  the thought for pre-order is easy to come up with(we want root-left-right), so we just need to  
  * pop the top element every element
  * and put right child before left child into stack
      then we can get the pre-order traversal

**notice the similirity of these two traversal method**, we can use the thought
    of pre-order method to came up with the thought for post-order traversal

This is the method:     

> The classic method to implement post order travsal is to use two stacks.
The first is to use pre-order and the second is to use invert the order

The code is ：
```java
      public List<Integer> postOrder (TreeNode root) {

        //never forget to deal with corner case
        if (root == null) {
          return new ArrayList<Integer>();
         }

         //use Deque, not stack
         Deque<TreeNode> stack1 = new ArrayDeque<>();
         Deque<Integer> stack2 = new ArrayDeque<>();
         stack1.addFirst(root);

         while(!stack1.isEmpty) {
           TreeNode cur = stack1.removeFirst();
           stack2.addFirst(cur.val);

           //be careful for null child
           if (cur.left != null) {
            stack1.addFirst(cur.left);
           }
           if (cur.right != null) {
            stack1.addFirst(cur.right);
           }
         }

         // build arraylist using deque
         return new ArrayList<Integer>(stack2);
      }
```

## 2.summary:
    * pre-order is the simplest thought
    * never forget corner case
    * we can build arraylist directly by using Deque
          new ArrayList<Integer>(stack2)
