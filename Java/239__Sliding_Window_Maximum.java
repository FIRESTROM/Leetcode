class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;
        Deque dq = new LinkedList();
        int len = nums.length;
        int[] result = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[(Integer) dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        int idx = 0;
        for (int j = k; j < len; j++) {
            result[idx++] = nums[(Integer) dq.peek()];
            while(!dq.isEmpty() && (Integer) dq.peek() <= j - k)
                dq.removeFirst();
            while(!dq.isEmpty() && nums[j] > nums[(Integer) dq.peekLast()])
                dq.removeLast();
            dq.addLast(j);
        }
        result[idx] = nums[(Integer) dq.peek()];
        return result;
    }
}
