class Solution {

    Map<Integer, int[]> map;

    public int[] beautifulArray(int N) {
        map = new HashMap();
        return helper(N);
    }

    public int[] helper(int N) {
        if (map.containsKey(N))
            return map.get(N);
        int[] result = new int[N];
        if (N == 1) {
            result[0] = 1;
        } else {
            int t = 0;
            for (int x: helper((N + 1)/2))  // odds
                result[t++] = 2 * x - 1;
            for (int x: helper(N / 2))  // evens
                result[t++] = 2 * x;
        }
        map.put(N, result);
        return result;
    }
}
