class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] result = new double[N][N];
        result[r][c] = 1.0;
        for (int time = 0; time < K; time++) {
            double[][] temp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (result[i][j] != 0) {
                        List<int[]> next_steps = helper(N, i, j);
                        for (int[] pos : next_steps)
                            temp[pos[0]][pos[1]] += result[i][j] / 8;
                    }
                }
            }
            result = temp;
        }
        double result_prob = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result_prob += result[i][j];
            }
        }
        return result_prob;
    }

    private List<int[]> helper(int N, int r, int c) {
        List<int[]> next_steps = new ArrayList<>();
        if (r - 2 >= 0 && c - 1 >= 0) next_steps.add(new int[]{r - 2, c - 1});
        if (r - 2 >= 0 && c + 1 < N) next_steps.add(new int[]{r - 2, c + 1});
        if (r - 1 >= 0 && c - 2 >= 0) next_steps.add(new int[]{r - 1, c - 2});
        if (r - 1 >= 0 && c + 2 < N) next_steps.add(new int[]{r - 1, c + 2});
        if (r + 1 < N && c - 2 >= 0) next_steps.add(new int[]{r + 1, c - 2});
        if (r + 1 < N && c + 2 < N) next_steps.add(new int[]{r + 1, c + 2});
        if (r + 2 < N && c - 1 >= 0) next_steps.add(new int[]{r + 2, c - 1});
        if (r + 2 < N && c + 1 < N) next_steps.add(new int[]{r + 2, c + 1});
        return next_steps;
    }
}


// Solution With Memory
class Solution {
    int[] dr = {2, 2, 1, 1, -2, -2, -1, -1};
    int[] dc = {-1, 1, -2, 2, -1, 1, -2, 2};
    Double[][][] memo;
    int N;
    public double knightProbability(int N, int K, int r, int c) {
        memo = new Double[N][N][K + 1];
        this.N = N;
        return dfs(K, r, c);
    }
    private double dfs(int k, int r, int c) {
        if (k <= 0)
            return 1;
        if (memo[r][c][k] != null)
            return memo[r][c][k];
        double result = 0;
        for (int x = 0; x < 8; x++) {
            int newR = dr[x] + r;
            int newC = dc[x] + c;
            if (newR >= 0 && newC >= 0 && newR < N && newC < N) {
                result += dfs(k - 1, newR, newC) /  Math.pow(8, 1);
            }
        }
        memo[r][c][k] = result;
        return result;
    }
}
