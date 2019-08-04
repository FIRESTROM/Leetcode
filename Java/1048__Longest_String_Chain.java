class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length, result = 0;
		int[] cache = new int[n];
        Arrays.fill(cache, 1);
		Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(words[i], i);
        for (int i = 0; i < n; i++)
            result = Math.max(result, helper(words, i, map, cache));
        return result;
    }

     private int helper(String[] words, int start, Map<String, Integer> map, int[] cache) {
        if (cache[start] != 1) return cache[start];
        for (int j = 0; j < words[start].length(); j++) {
            String s = words[start];
            String ss = s.substring(0, j) + s.substring(j + 1, s.length());
            if (map.containsKey(ss))
                cache[start] = Math.max(cache[start], 1 + helper(words, map.get(ss), map, cache));
        }
        return cache[start];
    }
}
