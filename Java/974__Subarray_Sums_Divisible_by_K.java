class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] mod_k = new int[K];
        mod_k[0] = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum % K < 0) {
                mod_k[sum % K + K] += 1;
            } else {
                mod_k[sum % K] += 1;
            }
        }
        int result = 0;
        for (int i = 0; i < K; i++) {
            if (mod_k[i] >= 2) {
                result += mod_k[i] * (mod_k[i] - 1) / 2;
            }
        }

        return result;
    }
}
