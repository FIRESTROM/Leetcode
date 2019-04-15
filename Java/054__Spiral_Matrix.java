class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int r_start = 0, r_end = matrix.length - 1;
        int c_start = 0, c_end = matrix[0].length - 1;
        while (r_start <= r_end && c_start <= c_end) {
            for (int j = c_start; j <= c_end; j++) {
                result.add(matrix[r_start][j]);
            }
            for (int i = r_start + 1; i <= r_end; i++) {
                result.add(matrix[i][c_end]);
            }
            if (r_start < r_end && c_start < c_end) {
                for (int j = c_end - 1; j >= c_start; j--) {
                    result.add(matrix[r_end][j]);
                }
                for (int i = r_end - 1; i >= r_start + 1; i--) {
                    result.add(matrix[i][c_start]);
                }
            }
            r_start++;
            r_end--;
            c_start++;
            c_end--;
        }
        return result;
    }
}
