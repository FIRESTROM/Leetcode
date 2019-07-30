class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                rowMaxes[i] = Math.max(rowMaxes[i], grid[i][j]);
                colMaxes[j] = Math.max(colMaxes[j], grid[i][j]);
        }
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                result += Math.min(rowMaxes[i], colMaxes[j]) - grid[i][j];

        return result;
    }
}
