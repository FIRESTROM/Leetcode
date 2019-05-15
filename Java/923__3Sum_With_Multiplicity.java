class Solution {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(A);
        int result = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1, k = A.length - 1;
            int sum;
            while (j < k) {
                sum = A[i] + A[j] + A[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    if (A[j] == A[k]) {
                        result += (k - j + 1) * (k - j) / 2;
                        result %= MOD;
                        break;
                    } else {
                        int left = 1, right = 1;
                        while (A[j] == A[j + 1]) {
                            left++;
                            j++;
                        }
                        while (A[k] == A[k - 1]) {
                            right++;
                            k--;
                        }
                        result += left * right;
                        result %= MOD;
                        j++;
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
