class MyQueue {

    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
         stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp_stack = new Stack<>();
        while(!stack.isEmpty())
            temp_stack.push(stack.pop());
        stack.push(x);
        while(!temp_stack.isEmpty())
            stack.push(temp_stack.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack.isEmpty())
            throw new RuntimeException("stack is empty already");
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack.isEmpty())
            throw new RuntimeException("stack is empty already");
        int val = stack.pop();
        stack.push(val);
        return val;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
