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

// Use Trie

class Solution {

    class TireNode {
        String word;
        TireNode[] children = new TireNode[26];
        public TireNode(){};
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return new ArrayList<>();
        int m = board.length, n = board[0].length;
        List<String> result = new LinkedList<>();
        TireNode root = buildTire(words);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                backTrack(board, root, result, i, j);
        return result;
    }

    private void backTrack(char[][] board, TireNode node, List<String> result, int i, int j) {
        char old_ij = board[xPos][yPos];
        if (old_ij == '#' || node.children[old_ij - 'a'] == null)
            return;
        node = node.children[old_ij - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0)
            backTrack(board, node, result, i - 1, j);
        if (j > 0)
            backTrack(board, node, result, i, j - 1);
        if (i < board.length - 1)
            backTrack(board, node, result, i + 1, j);
        if (j < board[0].length - 1)
            backTrack(board, node, result, i, j + 1);
        board[i][j] = old_ij;
    }

    private TireNode buildTire(String[] words) {
        TireNode root = new TireNode();
        for (String word : words) {
            TireNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null)
                    node.children[word.charAt(i) - 'a'] = new TireNode();
                node = node.children[word.charAt(i) - 'a'];
            }
            node.word = word;
        }
        return root;
    }
}
