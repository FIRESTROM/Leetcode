class TicTacToe {

    int r_score[][];
    int c_score[][];
    int d_score[][];
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        r_score = new int[n][2];
        c_score = new int[n][2];
        d_score = new int[2][2];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int cur_player = player - 1;
        r_score[row][cur_player]++;
        c_score[col][cur_player]++;
        if (row == col) d_score[0][cur_player]++;
        if (row + col == n - 1) d_score[1][cur_player]++;
        if (r_score[row][cur_player] == n || c_score[col][cur_player] == n || d_score[0][cur_player] == n || d_score[1][cur_player] == n){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
