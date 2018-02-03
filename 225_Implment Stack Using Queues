class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
       queue1 = new LinkedList<Integer>();
       queue2 = new LinkedList<Integer>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() != 1) {
            int ele = queue1.poll();
            queue2.offer(ele);
        }

        int res = queue1.poll();
        while ( queue2.size() != 0) {
            int ele = queue2.poll();
            queue1.offer(ele);
        }

        return res;
    }

    /** Get the top element. */
    public int top() {
         while (queue1.size() != 1) {
            int ele = queue1.poll();
            queue2.offer(ele);
        }

        int res = queue1.poll();
        queue2.offer(res);

        while ( queue2.size() != 0) {
            int ele = queue2.poll();
            queue1.offer(ele);
        }

        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
