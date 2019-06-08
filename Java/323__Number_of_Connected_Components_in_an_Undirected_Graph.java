class Solution {
    class DSU {
        int[] parent;

        DSU (int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
        }

        public int find(int x){
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            int xr = find(x), yr = find(y);
            parent[xr] = yr;
        }
    }

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges)
            dsu.union(edge[0], edge[1]);
        int result = 0;
        for (int i = 0; i < n; i++)
            if (dsu.find(i) == i)
                result++;
        return result;
    }
}
