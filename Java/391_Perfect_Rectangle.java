class Solution {
    int m = 0, n = 0;
    int minx = 0, miny = 0, maxx = 0, maxy = 0;

    public boolean isRectangleCover(int[][] rectangles) {
        minx = Integer.MAX_VALUE; miny = Integer.MAX_VALUE; // bottom-left most
        maxx = Integer.MIN_VALUE; maxy = Integer.MIN_VALUE; // top-right most
        for (int[] rec : rectangles) {
            minx = Math.min(minx, rec[0]);
            miny = Math.min(miny, rec[1]);
            maxx = Math.max(maxx, rec[2]);
            maxy = Math.max(maxy, rec[3]);
        }
        m = maxx - minx; n = maxy - miny;
        int count = 0;
        for (int[] rec : rectangles) {
            count += sum(rec[0] - minx, rec[1] - miny, rec[2] - minx, rec[3] - miny);
        }

        // if they don't sum up same, it can't be a perfect rectangle
        if (count != sum(0, 0, m, n)) return false;

        // but equal sum doesn't guarantee a perfect rectangle,
        // for example: [[1,1,2,2],[1,1,2,2],[1,1,2,2], [2,1,3,2],[2,2,3,3]]

        // similar idea as presented here: https://discuss.leetcode.com/topic/56052/really-easy-understanding-solution-o-n-java
        // all points, other than corners, must appear even number of times
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] rec : rectangles) {
            for (int num : fourCorners(rec)) {
                map.put(num, (map.containsKey(num) ? map.get(num) : 0) + 1);
            }
        }
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            if ((val&1) == 1 &&
                point2Num(0, 0) != key &&
                point2Num(0, n) != key &&
                point2Num(m, 0) != key &&
                point2Num(m, n) != key) {
                    return false;
                }
        }

        return true;
    }

    private int sum(int i1, int j1, int i2, int j2) { // bottom-left (i1, j1), top-right (i2, j2)
        return sum(i2, j2) - sum(i1, j2) - sum(i2, j1) + sum(i1, j1);
    }

    private int sum(int i, int j) { // top-right (i, j)
        return (1 + i * j) * i * j / 2;
    }

    private int[] fourCorners(int[] rec) {
        int tl = point2Num(rec[2] - minx, rec[1] - miny),
            tr = point2Num(rec[2] - minx, rec[3] - miny),
            bl = point2Num(rec[0] - minx, rec[1] - miny),
            br = point2Num(rec[0] - minx, rec[3] - miny);
        return new int[]{tl, tr, bl, br};
    }

    private int point2Num(int x, int y) {
        return x * m + y;
    }
}
