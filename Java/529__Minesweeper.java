class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board == null || board.length == 0)
            return board;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (i == click[0] && j == click[1])
                    this.dfs(board, i, j, new boolean[board.length][board[0].length], directions);
        return board;
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited, int[][] directions) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col])
            return;
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        }
        visited[row][col] = true;
        if (board[row][col] == 'E')
            board[row][col] = 'B';
        int count = 0;
        for (int i = 0; i < directions.length; i++) {
            int dx = row+directions[i][0];
            int dy = col+directions[i][1];
            if (dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length && board[dx][dy] == 'M')
                count++;
        }
        if (count > 0) {
            board[row][col] = (char) (count + '0');
            return;
        }
        for (int i = 0; i < directions.length; i++)
            dfs(board, row+directions[i][0], col+directions[i][1], visited, directions);
        return;
    }
}
