class Solution {

    static class DSU {
        int[] parent;
        DSU (int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        public int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return false;
            parent[xr] = yr;
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges)
            if (!dsu.union(edge[0], edge[1]))
                return false;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (dsu.find(i) == i)
                count++;
        return count == 1;
    }
}
