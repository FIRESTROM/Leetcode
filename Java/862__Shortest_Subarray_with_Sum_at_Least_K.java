class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0)
            return -1;
        int[] sums = new int[A.length + 1];
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + A[i - 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < sums.length; i++) {
            while (!deque.isEmpty() && sums[i] <= sums[deque.getLast()])
                deque.removeLast();
            while (!deque.isEmpty() && sums[i] - sums[deque.getFirst()] >= K) {
                result = Math.min(result, i - deque.getFirst());
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
