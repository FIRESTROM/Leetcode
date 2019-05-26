class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (String word : words) {
            boolean check = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    check = helper(board, word, 0, i, j);
                    if (check) break;
                }
                if (check) break;
            }
            if (check) result.add(word);
        }
        return result;
    }

    private boolean helper(char[][] board, String word, int index, int i, int j) {
        int m = board.length, n = board[0].length;
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] != word.charAt(index)) return false;
        char old_ij = board[i][j];
        board[i][j] = '*';
        boolean result = helper(board, word, index + 1, i + 1, j) || helper(board, word, index + 1, i - 1, j) || helper(board, word, index + 1, i, j + 1) || helper(board, word, index + 1, i, j - 1);
        board[i][j] = old_ij;
        return result;
    }
}
