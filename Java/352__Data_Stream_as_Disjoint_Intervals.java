class SummaryRanges {

    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val))
            return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if(l != null && h != null && map.get(l) + 1 == val && h == val + 1) {
            map.put(l, map.get(h));
            map.remove(h);
        } else if (l != null && map.get(l) + 1 >= val) {
            map.put(l, Math.max(map.get(l), val));
        } else if (h != null && h == val + 1) {
            map.put(val, map.get(h));
            map.remove(h);
        } else {
            map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (int key : map.keySet()) {
            result[i][0] = key;
            result[i][1] = map.get(key);
            i++;
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
