class TwoSum {

    TreeMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new TreeMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (map.size() < 1)
            return false;
        Integer lastKey = map.lastKey();
        Integer firstKey = map.firstKey();
        if (lastKey == null || firstKey == null || value > 2 * lastKey || value < 2 * firstKey)
            return false;
        for (int key : map.keySet()){
            int target = value - key;
            if (map.containsKey(target)) {
                if (target == key) {
                   if (map.get(key) > 1)
                       return true;
                   else
                       continue;
                } else
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
