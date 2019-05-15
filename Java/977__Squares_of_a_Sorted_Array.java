class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0;
        while (i < A.length - 1 && Math.abs(A[i]) >=  Math.abs(A[i + 1])) i++;
        result[0] = A[i] * A[i];
        int l = i - 1, r = i + 1;
        i = 1;
        while (l >= 0 && r < A.length) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                result[i] = A[r] * A[r];
                r++;
                i++;
            } else {
                result[i] = A[l] * A[l];
                l--;
                i++;
            }
        }
        if (l < 0) {
            while (r < A.length) {
                result[i] = A[r] * A[r];
                r++;
                i++;
            }
        } else if (r >= A.length) {
            while (l >= 0) {
                result[i] = A[l] * A[l];
                l--;
                i++;
            }
        }
        return result;
    }
}
