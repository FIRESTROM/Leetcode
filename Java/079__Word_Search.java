class Solution {

    public boolean helper(char[][] board, int x, int y, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (word.length() == 1 && board[x][y] == word.charAt(0)) {
            return true;
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            if (0 <= x + dx[i] && x + dx[i] < board.length && 0 <= y + dy[i] && y + dy[i] < board[0].length && board[x + dx[i]][y + dy[i]] == word.charAt(0)) {
                char origin = board[x + dx[i]][y + dy[i]];
                board[x + dx[i]][y + dy[i]] = '0';
                result = result || helper(board, x + dx[i], y + dy[i], word.substring(1));
                board[x + dx[i]][y + dy[i]] = origin;
            }
        }
        return result;
    }


    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}



// Another solution: DFS

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = dsf(board, word, i, j, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean dsf(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)){
            return false;
        }

        boolean result;
        board[i][j] += 60;
        result = dsf(board, word, i - 1, j, index + 1)
                || dsf(board, word, i + 1, j, index + 1)
                || dsf(board, word, i, j - 1, index + 1)
                || dsf(board, word, i, j + 1, index + 1);
        board[i][j] -= 60;
        return result;
    }
}
