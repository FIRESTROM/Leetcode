class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> temp = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (map.containsKey(temp)) {
                map.get(temp).add(s);
            } else {
                List<String> cur = new ArrayList<>();
                cur.add(s);
                map.put(temp, cur);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> cur : map.keySet()) {
            result.add(map.get(cur));
        }
        return result;
    }
}

// Another Solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List> result = new HashMap<>();
        for (String s : strs) {
            char[] s_list = s.toCharArray();
            Arrays.sort(s_list);
            String key = String.valueOf(s_list);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList());
            }
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}
