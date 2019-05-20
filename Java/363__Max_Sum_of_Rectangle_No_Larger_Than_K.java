class Solution {
    int [][] prefixSums;
    int R, C;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] colSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    colSum[i] += matrix[i][right];
                }
                result = Math.max(result, largestSumNoLargerThanK(colSum, k));
            }
        }
        return result;
    }

    private int largestSumNoLargerThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet();
        int sum = 0, result = Integer.MIN_VALUE;
        set.add(0);
        for (int val : nums) {
            sum += val;
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                result = Math.max(result, sum - ceiling);
            }
            set.add(sum);
        }
        return result;
    }
}
