class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) {
                int toRemove = nums[i - k];
                if (max.peek() < toRemove) {
                    min.remove(toRemove);
                } else {
                    max.remove(toRemove);
                }
            }
            if (!min.isEmpty() && nums[i] > min.peek())
                min.offer(nums[i]);
            else
                max.offer(nums[i]);
            if (max.size() - min.size() > 1 || max.size() < min.size())
                balance(max, min);
            if (i >= k - 1) {
                if (k % 2 == 0)
                    result[i - k + 1] = ((double) max.peek() + (double) min.peek()) / 2.0;
                else
                    result[i - k + 1] = (double) max.peek();
            }
        }
        return result;
    }

    private void balance(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        while (max.size() - min.size() > 1)
            min.offer(max.poll());
        while (max.size() < min.size())
            max.offer(min.poll());
    }
}
