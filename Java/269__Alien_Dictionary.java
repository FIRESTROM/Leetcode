class Solution {

    enum Color {
        White,
        Gray,
        Black
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Set<Character>> adj_map = new HashMap<>();
        for (String word : words)
            for (char c : word.toCharArray())
                adj_map.putIfAbsent(c, new HashSet<>());
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                while (k < Math.min(words[i].length(), words[j].length()) && words[i].charAt(k) == words[j].charAt(k)) k++;
                if (k < Math.min(words[i].length(), words[j].length()))
                    adj_map.get(words[i].charAt(k)).add(words[j].charAt(k));
            }
        }
        StringBuilder result = new StringBuilder();
        Color[] visited = new Color[26];
        Arrays.fill(visited, Color.White);
        // do topo sort and check cycle at the same time
        for (Map.Entry<Character, Set<Character>> e : adj_map.entrySet())
            if (visited[e.getKey() - 'a'] == Color.White && !topoSort(e.getKey(), adj_map, result, visited))
                return "";
        return result.reverse().toString();
    }

    private boolean topoSort(Character u, Map<Character, Set<Character>> adj_map, StringBuilder result, Color[] visited) {
        visited[u - 'a'] = Color.Gray;
        if (adj_map.containsKey(u))
            for (char v : adj_map.get(u))
                if (visited[v - 'a'] == Color.Gray || (visited[v - 'a'] == Color.White && !topoSort(v, adj_map, result, visited)))
                    return false;
        visited[u - 'a'] = Color.Black;
        result.append(u);
        return true;
    }
}
