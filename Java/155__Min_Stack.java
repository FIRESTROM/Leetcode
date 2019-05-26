class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.isEmpty() || min_stack.peek() >= x) {
            min_stack.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (min_stack.peek() == val)
            min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
