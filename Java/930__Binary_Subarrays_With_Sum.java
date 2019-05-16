class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] count = new int[A.length + 1];
        count[0] = 1;
        int result = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= S) result += count[sum - S];
            count[sum] += 1;
        }

        return result;
    }
}
