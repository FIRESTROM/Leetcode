class Solution {

    HashMap<String, ArrayList<Integer>> locations;

    public int shortestWordDistance(String[] words, String word1, String word2) {
        this.locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!locations.containsKey(words[i])) {
                locations.put(words[i], new ArrayList<Integer>());
            }
            locations.get(words[i]).add(i);
        }
        return helper(word1, word2);
    }

    private int helper(String word1, String word2) {
        if (word1.equals(word2)) {
            int result = Integer.MAX_VALUE;
            ArrayList<Integer> lst = locations.get(word1);
            for (int i = 1; i < lst.size(); i++) {
                if (result > lst.get(i) - lst.get(i - 1))
                    result = lst.get(i) - lst.get(i - 1);
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        } else {
            ArrayList<Integer> lst_1 = this.locations.get(word1), lst_2 = this.locations.get(word2);
            int i = 0, j = 0, result = Integer.MAX_VALUE;
            while (i < lst_1.size() && j < lst_2.size()) {
                result = Math.min(result, Math.abs(lst_1.get(i) - lst_2.get(j)));
                if (lst_1.get(i) < lst_2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return result;
        }
    }
}

// Better Solution
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, len = words.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                if (word1.equals(word2)) {
                    if (p1 != -1) result = Math.min(result, i - p1);
                    p1 = i;
                } else {
                    p1 = i;
                    if (p2 != -1) result = Math.min(result, p1 - p2);
                }
            } else if (word.equals(word2)) {
                p2 = i;
                if (p1 != -1) result = Math.min(result, p2 - p1);
            }
        }
        return result;
    }
}
