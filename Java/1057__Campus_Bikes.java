class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Map<Integer, List<int[]>> map = new TreeMap();
        Set<Integer> worker_set = new TreeSet(), bike_set = new TreeSet();
        int[] result = new int[workers.length];

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = getManhattanDistance(workers[i], bikes[j]);
                if (!map.containsKey(dist))
                    map.put(dist, new ArrayList());
                map.get(dist).add(new int[]{i, j});
            }
        }

        for (List<int[]> pairList: map.values()) {
            for (int[] pair : pairList) {
                int w = pair[0], b = pair[1];
                if (!worker_set.contains(w) && !bike_set.contains(b)) {
                    result[w] = b;
                    worker_set.add(w);
                    bike_set.add(b);
                }
            }
        }

        return result;
    }

    private int getManhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
