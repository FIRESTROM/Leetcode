public class Solution {

    int[] roots;
    int count;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        roots = new int[m * n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i< m * n; i++)
            roots[i] = i;
        for (int[] pos : positions) {
            int x = pos[0], y = pos[1];
            if (matrix[x][y] == 1) {
                result.add(count);
                continue;
            }
            int cur = x * n + y;
            matrix[x][y] = 1;
            count++;
            if (y > 0 && matrix[x][y - 1] > 0) union(cur, cur - 1);
            if (y < n - 1 && matrix[x][y + 1] > 0) union(cur, cur+1);
            if (x > 0 && matrix[x - 1][y] > 0) union(cur, cur - n);
            if (x < m - 1 && matrix[x + 1][y] > 0) union(cur, cur + n);
            result.add(count);
        }
        return result;
    }

    private int find(int t) {
        while (t != roots[t]){
            roots[t] = roots[roots[t]];
            t = roots[t];
        }
        return t;
    }

    private void union(int a, int b) {
        int a_root = find(a), b_root = find(b);
        if (a_root != b_root) {
            roots[a_root] = b_root;
            count--;
        }
    }
}
