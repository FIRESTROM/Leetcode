class Solution {
    public int oddEvenJumps(int[] A) {
        int len = A.length;
        if (len <= 1)
            return len;
        boolean[] odd = new boolean[len];
        boolean[] even = new boolean[len];
        odd[len - 1] = even[len - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(A[len - 1], len - 1);
        for (int i = len - 2; i >= 0; i--) {
            int v = A[i];
            if (map.containsKey(v)) {
                odd[i] = even[map.get(v)];
                even[i] = odd[map.get(v)];
            } else {
                Integer lower = map.lowerKey(v);
                Integer higher = map.higherKey(v);

                if (lower != null)
                    even[i] = odd[map.get(lower)];
                if (higher != null) {
                    odd[i] = even[map.get(higher)];
                }
            }
            map.put(v, i);
        }

        int result = 0;
        for (boolean check: odd)
            if (check)
                result++;
        return result;
    }
}
