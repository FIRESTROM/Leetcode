class MovingAverage {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    ListNode dummy = null;
    ListNode cur = null;
    int total_size;
    int capacity;
    int total;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        dummy = new ListNode(0);
        cur = dummy;
        total_size = 0;
        capacity = size;
        total = 0;
    }

    public double next(int val) {
        total_size++;
        int numToRemove = 0;
        if (total_size > capacity) {
            if (dummy.next == null) return 0.0;
            numToRemove = dummy.next.val;
            dummy.next = dummy.next.next;
            total_size--;
        }
        total += val;
        total -= numToRemove;
        cur.next = new ListNode(val);
        cur = cur.next;
        return (double) total / total_size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
