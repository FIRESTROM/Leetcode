class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] cache = new int[m + 1][n + 1];
        return helper(0, 0, dungeon, cache);
    }

    private int helper(int m, int n, int[][] dungeon, int[][] cache) {
        if (m == dungeon.length - 1 && n > dungeon[0].length - 1) return 1;
        if (m > dungeon.length - 1 && n == dungeon[0].length - 1) return 1;
        if (m > dungeon.length - 1 || n > dungeon[0].length - 1) return Integer.MAX_VALUE;
        if (cache[m][n] == 0) {
            int minHP = Math.min(helper(m + 1, n, dungeon, cache), helper(m, n + 1, dungeon, cache)) - dungeon[m][n];
            cache[m][n] = (minHP <= 0) ? 1 : minHP;
        }
        return cache[m][n];
    }
}
