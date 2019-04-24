class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> map.get(s1).equals(map.get(s2)) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));
        for (String str : map.keySet()) {
            queue.add(str);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
