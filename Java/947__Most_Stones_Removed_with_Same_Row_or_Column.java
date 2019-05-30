class Solution {

    int islands = 0;

    public int removeStones(int[][] stones) {
        int[] parents = new int[stones.length];
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;
        islands = stones.length;
        for (int i = 0; i < stones.length - 1; i++)
            for (int j = i + 1; j < stones.length; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    union(i, j, parents);

        return stones.length - islands;
    }

    public void union(int i, int j, int[] parents) {
        int x = find(i, parents);
        int y = find(j, parents);
        if (x == y) return;
        parents[x] = parents[y];
        islands--;
    }

    public int find(int i, int[] parents) {
        if (i != parents[i])
            parents[i] = find(parents[i], parents);
        return parents[i];
    }
}
