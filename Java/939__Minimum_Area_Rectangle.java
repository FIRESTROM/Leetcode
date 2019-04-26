class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, List<Integer>> x_map = new HashMap<Integer, List<Integer>>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            if (!x_map.containsKey(x)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(y);
                x_map.put(x, temp);
            } else {
                x_map.get(x).add(y);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (x_map.get(points[i][0]).contains(points[j][1]) && x_map.get(points[j][0]).contains(points[i][1])) {
                        result = Math.min(result, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }
}
