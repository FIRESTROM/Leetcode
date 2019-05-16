class Solution {
    public int longestOnes(int[] A, int K) {
        int zeroCount = 0, start = 0, result = 0;
		for (int end = 0; end < A.length; end++) {
				if (A[end] == 0) zeroCount++;
				if (zeroCount > K) {
					while (A[start] != 0) start++;
					start++;
					zeroCount--;
				}
				result = Math.max(result, end - start + 1);
		}
		return result;
    }
}
