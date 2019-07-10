class NumMatrix {

    int m, n;
    int[][] data;    // stores matrix[][]
    int[][] BITree; // 2-D binary indexed tree

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        m = matrix.length;
        n = matrix[0].length;
        data = new int[m][n];
        BITree = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]); // init BITree[][]
                data[i][j] = matrix[i][j];   // init data[][]
            }
        }
    }

    public void update(int i, int j, int val) {
        int diff = val - data[i][j];  // get the diff
        data[i][j] = val;             // update data[][]
        i++; j++;
        while (i <= m) {
            int k = j;
            while (k <= n) {
                BITree[i][k] += diff; // update BITree[][]
                k += k & (-k); // update column index to that of parent
            }
            i += i & (-i);   // update row index to that of parent
        }
    }

    int getSum(int i, int j) {
        int result = 0;
        i++; j++;
        while (i > 0) {
            int k = j;
            while (k > 0) {
                result += BITree[i][k]; // accumulate the sum
                k -= k & (-k); // move column index to parent node
            }
            i -= i & (-i);   // move row index to parent node
        }
        return result;
    }

    public int sumRegion(int i1, int j1, int i2, int j2) {
        return getSum(i2, j2) - getSum(i1 - 1, j2) - getSum(i2, j1 - 1) + getSum(i1 - 1, j1 - 1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
