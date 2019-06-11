class MyCircularQueue {

    int[] data;
    private int front, tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        else {
            data[tail] = value;
            tail = (tail + 1) % data.length;
            size++;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        else {
            data[front] = 0;
            front = (front + 1) % data.length;
            size--;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        else
            return data[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        else
            return data[(tail + data.length - 1) % data.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
