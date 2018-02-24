## LeetCode124

作者：韩灵全

版本：2018-02-23


## 题⽬描述
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting
node to any node in the tree along the parent-child connections. The path must contain
at least one node and does not need to go through the root.


## 思路报告
求最大路径和，能不能从up to down 呢？ 不可以，因为如果这样走的话，就默认一定要选root
这个点了，但是事实上不是。
那就试试down-to-up，左边返回给我一个左边最大path sum，右边返回右边最大path sum，
root自己结合自己决定**选左边，还是选右边，还是都选（这里考虑了负数情况**， 来决定最大path sum。然后往上一层返回的话，因为题目要求父子相连的关系，那我只能往上一层返回一个左子树最大+root或者右子树
最大+root。
因为每一层都会计算出当前最大path，所以我们需要一个全局最大变量来实时记录最大值。


## 需要注意的细节：
1.最长的path和最大的path sum没有关系

2.点的value可以是负数

3.值传递和引用传递（套路总结），解释为什么用int[] 存max

代码如下

```java
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            throw new  IllegalArgumentException("need a node!");
        }

        int[] max = new int[1];
        max[0] = root.val;
        maxSumHelper(root, max);
        return max[0];
    }

    private int maxSumHelper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxSumHelper(root.left, max);
        int rightMax = maxSumHelper(root.right,max);


        int cur = Math.max(root.val, Math.max(leftMax + root.val, rightMax + root.val));
        max[0] = Math.max(max[0], Math.max(cur,root.val + leftMax + rightMax));

        return cur;
    }
}

```


## 套路总结
* 套路1：当我们需要引入一个全局变量时，我们可以利用引用传递的方式把需要更新的值传到函数中，因为引用传递，引用指向的值是会改变的。
* 套路2：什么时候自上而下，什么时候自下而上？
      
    1.自上而下：不需要知道上边发生了什么，只要有一个参数传下来就可以，我一直处理到叶子节点就有解。题目一般是要求结果要放到一个容器结构（list，arry之类）。
    
    2.自下而上，自上而下很难想通，或者偏离题目意思。这时候从下而上，一直处理，当处理到root的时候正好就是解，就用自下而上。题目一般要求返回一个什么样的值（本题，返回最大path sum）。
* 套路3：自上而下，自下而上 和前中后序遍历的关系

    1) up to down对应pre-order
      2) down to up对应post-order

        代码模板：
        //处理代码放在这---前序/自上而下
        helper(root.left);
        //处理代码放在这---中序
        helper(root.right);
        //处理代码放在这---后序/自下而上
* 套路4：按层访问处理，用queue。
