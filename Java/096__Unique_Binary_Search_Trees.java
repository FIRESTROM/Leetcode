class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
          for (int root = 1; root <= i; root++) {
            G[i] += G[root - 1] * G[i - root];
          }
        }
        return G[n];
    }
}
