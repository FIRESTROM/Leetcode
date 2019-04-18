class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> data = new HashSet<>();
        for (int num : nums) {
            data.add(num);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_len = 0;
        for (Integer val : data) {
            boolean t1 = map.containsKey(val - 1);
            boolean t2 = map.containsKey(val + 1);
            if (t1 && t2) {
                int start = map.get(val - 1);
                int end = map.get(val + 1);
                map.remove(start);
                map.remove(val - 1);
                map.remove(end);
                map.remove(val + 1);
                map.put(start, end);
                map.put(end, start);
            } else if (t1) {
                int start = map.get(val - 1);
                int end = val;
                map.remove(start);
                map.remove(val - 1);
                map.put(start, end);
                map.put(end, start);
            } else if (t2) {
                int start = val;
                int end = map.get(val + 1);
                map.remove(end);
                map.remove(val + 1);
                map.put(start, end);
                map.put(end, start);
            } else {
                map.put(val, val);
                map.put(val, val);
            }
        }

        for (Integer key : map.keySet()) {
            if (max_len < Math.abs(key - map.get(key)) + 1) {
                max_len = Math.abs(key - map.get(key)) + 1;
            }
        }
        return max_len;
    }
}

// Easier Solution
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> data = new HashSet<Integer>();
        for (int num : nums) {
            data.add(num);
        }

        int max_len = 0;

        for (int num : num_set) {
            if (!data.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (data.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                max_len = Math.max(max_len, currentStreak);
            }
        }

        return max_len;
    }
}
