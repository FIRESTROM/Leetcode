class Solution {

    int HIT = -1;
    int BRICK = 1;
    int VISITED = 2;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int [] result = new int[hits.length];
		// Mark erased bricks
        for (int [] hit : hits) {
            if (grid[hit[0]][hit[1]] == BRICK) {
                grid[hit[0]][hit[1]] = HIT;
            }
        }
		/*
			Run Depth First Search from top row in order to know
			which bricks are left after every erase operation.
			We should mark these bricks as visited.
		*/
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == BRICK) {
                dfs(grid, 0, j);
            }
        }
		/*
			Run the hits array in reverse order.
			We should run a new DFS from here in order to know which cells can be visited.
			Count the new visited cells except the DFS root cell (because it was erased, it didn't fall)
		*/
        for (int k = result.length - 1; k >= 0; k--) {
            int i = hits[k][0], j = hits[k][1];
            if (grid[i][j] == HIT) {
                grid[i][j] = BRICK;
                if (isConnected(grid, i, j))
                    result[k] = dfs(grid, i, j) - 1;
            }
        }
        return result;
    }

    public boolean isConnected(int [][] grid, int i, int j) {
        return i - 1 < 0 || (grid[i - 1][j] == VISITED) ||
                (i + 1 < grid.length && grid[i + 1][j] == VISITED) ||
                (j - 1 >= 0 && grid[i][j - 1] == VISITED) ||
                (j + 1 < grid[0].length && grid[i][j + 1] == VISITED);
    }

    public int dfs(int [][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != BRICK) {
            return 0;
        }
        grid[i][j] = VISITED;
        int sum = 1;
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid,  i - 1, j);
        sum += dfs(grid, i, j + 1);
        sum += dfs(grid, i, j - 1);
        return sum;
    }
}
