class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i - K];
            if (i >= K-1) W[i - K + 1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] result = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (result[0] == -1 || W[i] + W[j] + W[k] >
                    W[result[0]] + W[result[1]] + W[result[2]]) {

                result[0] = i;
                result[1] = j;
                result[2] = k;
            }
        }
        return result;
    }
}
