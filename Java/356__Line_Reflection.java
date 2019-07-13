class Solution {
    public boolean isReflected(int[][] points) {
        double sum = 0.0;
        int count = 0;
        // x, set of y
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            if (map.get(point[0]).add(point[1])) {
                sum += point[0];
                count++;
            }
        }
        double middle = sum / count;
        for (int[] point : points) {
            if (point[0] > middle) continue;
            if ((double) point[0] == middle) {
                continue;
            }
            int rightX = (int) (middle + (middle - point[0]));
            if (map.containsKey(rightX) && map.get(rightX).contains(point[1])) {
                // ok
            } else {
                return false;
            }
        }
        return true;
    }
}
