class WordDistance {

    HashMap<String, ArrayList<Integer>> locations;

    public WordDistance(String[] words) {
        this.locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!locations.containsKey(words[i])) {
                locations.put(words[i], new ArrayList<Integer>());
            }
            locations.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> map_1 = this.locations.get(word1), map_2 = this.locations.get(word2);
        int i = 0, j = 0, result = Integer.MAX_VALUE;
        while (i < map_1.size() && j < map_2.size()) {
            result = Math.min(result, Math.abs(map_1.get(i) - map_2.get(j)));
            if (map_1.get(i) < map_2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
