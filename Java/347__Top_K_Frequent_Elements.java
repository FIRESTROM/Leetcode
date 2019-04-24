class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer> ((n1, n2) -> map.get(n1) - map.get(n2));
        for (int val : map.keySet()) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
