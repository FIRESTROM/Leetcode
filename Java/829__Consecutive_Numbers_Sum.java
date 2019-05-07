class Solution {
    public int consecutiveNumbersSum(int N) {
        if (N == 1) {
            return 1;
        }
        int i = 1, result = 0;
        while (i * (i + 1) <= 2 * N) {
            if (i % 2 == 1 && N % i == 0) {
                result++;
            } else if (i % 2 == 0 && (N + (i / 2)) % i == 0) {
                result++;
            }
            i++;
        }
        return result;
    }
}
