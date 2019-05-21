class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0)
            return null;
        int m = A.length, n = A[0].length, p = B[0].length;
        int[][] result = new int[m][p];
        for (int j = 0; j < p; j++) {
            for (int i = 0; i < m; i++) {
                for (int temp = 0; temp < n; temp++) {
                    result[i][j] += A[i][temp] * B[temp][j];
                }
            }
        }
        return result;
    }
}
