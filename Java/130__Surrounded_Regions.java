class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') save(board, i, 0, m, n);
            if (board[i][n - 1] == 'O') save(board, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') save(board, 0, j, m, n);
            if (board[m - 1][j] == 'O') save(board, m - 1, j, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    private void save(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1)
            return;
        if (board[i][j] == 'O') board[i][j] = 'S';
        if (i > 1 && board[i - 1][j] == 'O') save(board, i - 1, j, m, n);
        if (i < m - 2 && board[i + 1][j] == 'O') save(board, i + 1, j, m, n);
	    if (j > 1 && board[i][j - 1] == 'O') save(board, i, j - 1, m, n);
        if (j < n - 2 && board[i][j + 1] == 'O') save(board, i, j + 1, m, n);
    }
}
