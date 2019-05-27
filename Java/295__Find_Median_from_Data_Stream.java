class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (!min.isEmpty() && num > min.peek())
            min.offer(num);
        else
            max.offer(num);
        if (max.size() - min.size() > 1 || max.size() < min.size())
            balance(max, min);
    }

    public double findMedian() {
        if ((max.size() + min.size()) % 2 == 0) {
            return ((double) max.peek() + (double) min.peek()) / 2.0;
        } else {
            return (double) max.peek();
        }
    }

    private void balance(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        while (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        while (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
