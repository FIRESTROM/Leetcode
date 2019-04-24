class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length;
        if (N < 3) {
            return N;
        }
        int result = 0;
        for (int i = 1; i < N; i++) {
            int overlap = 1, horizontal = 1;
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                } else if (y == 0) {
                    horizontal++;
                    continue;
                }
                double key = (double) x / y + 0.0000;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            result = Math.max(result, overlap);
            for (int val : map.values()) {
                result = Math.max(result, val + overlap);
            }
            result = Math.max(result, horizontal);
        }
        return result;
    }
}
