class Solution {
    public int longestMountain(int[] A) {
        int N = A.length;
        int result = 0, base = 0;
        while (base < N) {
            int end = base;
            if (end + 1 < N && A[end] < A[end + 1]) {
                while (end + 1 < N && A[end] < A[end + 1]) end++;
                if (end + 1 < N && A[end] > A[end + 1]) {
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    result = Math.max(result, end - base + 1);
                }
            }
            base = Math.max(end, base + 1);
        }

        return result;
    }
}

// Another Smart Solution Using DP
class Solution {
    public int longestMountain(int[] A) {
        int result = 0;
        int n = A.length;
        if (n > 0) {
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 0;
            right[n - 1] = 0;
            for (int i = 1; i < n; i++) {
                if (A[i] > A[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 0;
                }
            }
            for (int j = n - 2; j >= 0; j--) {
                if (A[j] > A[j + 1]) {
                    right[j] = right[j + 1] + 1;
                } else {
                    right[j] = 0;
                }
            }
            for (int k = 0; k < n; k++) {
                if (left[k] > 0 && right[k] > 0) {
                    result = Math.max(result, left[k] + right[k] + 1);
                }
            }

        }
        return result;
    }
}
