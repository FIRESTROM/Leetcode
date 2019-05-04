class Solution {
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<ArrayList<Integer>>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                shape = new ArrayList<Integer>();
                helper_dfs(i, j, 0);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    private void helper_dfs(int i, int j, int direction) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length &&
                grid[i][j] == 1 && !seen[i][j]) {
            seen[i][j] = true;
            shape.add(direction);
            helper_dfs(i + 1, j, 1);
            helper_dfs(i - 1, j, 2);
            helper_dfs(i, j + 1, 3);
            helper_dfs(i, j - 1, 4);
            shape.add(0);
        }
    }
}
