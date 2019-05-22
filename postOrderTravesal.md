The classic method to implement post order travsal is to use two stacks.
The first is to use pre-order and the second is to use invert the order

The code is ：

      public List<Integer> postOrder (TreeNode root) {
        if (root == null) {
          return new ArrayList<Integer>();
         }
         
         Deque<TreeNode> stack1 = new ArrayDeque<>();
         Deque<Integer> stack2 = new ArrayDeque<>();
         stack1.addFirst(root);
         
         while(!stack1.isEmpty) {
           TreeNode cur = stack1.removeFirst();
           stack2.addFirst(cur.val);
           
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
