class RandomizedCollection {

    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if (!map.containsKey(val)) {
            result = true;
            HashSet<Integer> indexes = new HashSet<>();
            map.put(val, indexes);
        }
        HashSet<Integer> temp = map.get(val);
        if (temp.size() == 0) result = true;
        temp.add(list.size());
        list.add(val);
        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indexes = map.get(val);
        if (!map.containsKey(val) || map.get(val).size() == 0) return false;
        else {
            indexes = map.get(val);
            int index = indexes.iterator().next();
            indexes.remove(index);
            if (index != list.size() - 1) {
                int last = list.get(list.size() - 1);
                Set<Integer> indexesOfLast = map.get(last);
                list.set(index, last);
                indexesOfLast.remove(list.size() - 1);
                indexesOfLast.add(index);
            }
            list.remove(list.size() - 1);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
