class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;
        int result = A[0], cur = A[0];
        for (int i = 1; i < N; i++) {
            cur = A[i] + Math.max(cur, 0);
            result = Math.max(result, cur);
        }
        int[] rightsums = new int[N];
        rightsums[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--)
            rightsums[i] = rightsums[i + 1] + A[i];
        int[] max_right = new int[N];
        max_right[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--)
            max_right[i] = Math.max(max_right[i + 1], rightsums[i]);
        int left_sum = 0;
        for (int i = 0; i < N - 2; i++) {
            left_sum += A[i];
            result = Math.max(result, left_sum + max_right[i + 2]);
        }
        return result;
    }
}
