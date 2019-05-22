class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[][]{};
        int[][] result = new int[n][n];
        int upBounds = 0, downBounds = n - 1;
        int rightBounds = n - 1, leftBounds = 0;
        int count = 1;
        while (count <= n * n) {
            for (int i = leftBounds; i <= rightBounds; i++)
                result[upBounds][i] = count++;
            for (int i = upBounds + 1; i <= downBounds; i++)
                result[i][rightBounds] = count++;
            for (int i = rightBounds - 1; i >= leftBounds; i--)
                result[downBounds][i] = count++;
            for (int i = downBounds - 1; i > upBounds; i--)
                result[i][leftBounds] = count++;
            upBounds++;
            downBounds--;
            rightBounds--;
            leftBounds++;
        }

        return result;
    }
}
