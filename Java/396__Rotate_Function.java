class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int current = 0, result = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            current += i * A[i];
            sum += A[i];
        }

        result = current;

        for (int i = A.length - 1; i >= 0; i--) {
            current = current + sum - A.length * A[i];
            result = Math.max(result, current);
        }

        return result;
    }
}
