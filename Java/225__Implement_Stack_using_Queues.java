class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int limit = queue.size() - 1, index = 0;
        while (index != limit) {
            queue.offer(queue.poll());
            index++;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int limit = queue.size(), index = 0;
        int result = 0;
        while (index != limit) {
            result = queue.poll();
            queue.offer(result);
            index++;
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
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
