class Solution {

    int count = 0;

    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];
        for (int start = 1; start <= 2; start++) {
            int c = count;
            visited[start] = true;
            dfs(start, visited, 1, m, n);
            visited[start] = false;
            count = c + (count - c) * 4;
        }
        visited[5] = true;
        dfs(5, visited, 1, m, n);
        visited[5] = false;
        return count;
    }

    private void dfs(int key, boolean[] visited, int len, int m, int n){
        if (len >= m && len <= n)
            count++;
        for (int nei = 1; nei <= 9; nei++) {
            if (len == n) break;
            if (key == nei || visited[nei]) continue;
            int d = nei + key;
            if (d % 2 == 0 && (Math.abs((key - 1) / 3 - (nei - 1) / 3) > 1 || Math.abs((key - 1) % 3 - (nei - 1) % 3) > 1) && !visited[d / 2])
                continue;
            visited[nei] = true;
            dfs(nei, visited, len + 1, m, n);
            visited[nei] = false;
        }
    }
}
