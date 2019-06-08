class Solution {

    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(1, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int s = queue.remove();
            if (s == len * len)
                return dist.get(s);
            for (int dst = s + 1; dst <= Math.min(s + 6, len * len); dst++) {
                int i = len - 1 - (dst - 1) / len;
                int j = i % 2 != len % 2 ? (dst - 1) % len : len - 1 - (dst - 1) % len;
                int real_dst = board[i][j] == -1 ? dst : board[i][j];
                if (!dist.containsKey(real_dst)) {
                    dist.put(real_dst, dist.get(s) + 1);
                    queue.add(real_dst);
                }
            }
        }
        return -1;
    }

}
