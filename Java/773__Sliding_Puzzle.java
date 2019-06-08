class Solution {

    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        String start = new String();
        String dest = new String();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += String.valueOf(board[i][j]);
                dest += i == board.length - 1 && j == board[0].length - 1 ? "0" : String.valueOf(i * 3 + j + 1);
            }
        }
        if (start.equals(dest))
            return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                int index = cur.indexOf('0');
                int x = index / 3, y = index % 3;
                for (int i  =0; i < 4; i++) {
                    int nx = x + direction[i][0], ny = y + direction[i][1];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length)
                        continue;
                    int ni = nx * 3 + ny;
                    String nstate = swap(cur, index, ni);
                    if (nstate.equals(dest))
                        return steps;
                    if (visited.contains(nstate))
                        continue;
                    visited.add(nstate);
                    queue.offer(nstate);
                }
            }
        }
        return -1;
    }

    public String swap(String str, int i, int j) {
        char[] s = str.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return new String(s);
    }
}
