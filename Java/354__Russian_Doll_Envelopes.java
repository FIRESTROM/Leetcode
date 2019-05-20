class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[]b) {
                if (a[0] == b[0])
                    return Integer.compare(b[1], a[1]);
                else
                    return Integer.compare(a[0], b[0]);
            }
        });
        int[] data = new int[envelopes.length];
        for (int i = 0; i < data.length; i++)
            data[i] = envelopes[i][1];
        return helper(data);
    }

    private int helper(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int right = 0;
        for (int val : nums){
            int pos = Arrays.binarySearch(dp, 0, right, val);
            if (pos < 0)
                pos = - pos - 1;
            dp[pos] = val;
            if (pos == right)
                right++;
        }
        return right;
    }
}
