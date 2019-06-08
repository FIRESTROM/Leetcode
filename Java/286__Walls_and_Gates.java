class Solution {

    int EMPTY = Integer.MAX_VALUE;
    int GATE = 0;
    List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rooms[i][j] == GATE)
                    queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            for (int[] direction : DIRECTIONS) {
                int new_i = i + direction[0];
                int new_j = j + direction[1];
                if (new_i < 0 || new_j < 0 || new_i >= m || new_j >= n || rooms[new_i][new_j] != EMPTY)
                    continue;
                rooms[new_i][new_j] = rooms[i][j] + 1;
                queue.add(new int[]{new_i, new_j});
            }
        }
    }
}
