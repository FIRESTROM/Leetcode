class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    if (0 <= i + dx[k] && i + dx[k] < board.length && 0 <= j + dy[k] && j + dy[k] < board[0].length) {
                        if (board[i + dx[k]][j + dy[k]] % 2 == 1) {
                            count++;
                        }
                    }
                }
                if (board[i][j] == 1 && !(count == 2 || count == 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

}
