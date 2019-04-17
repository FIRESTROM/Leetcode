class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList.isEmpty()) {
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        if (!dict.contains(endWord)) {
            return result;
        }
        start.add(beginWord);
        end.add(endWord);
        buildMap(map, start, end, dict, false);
        List<String> cur_path = new ArrayList<>();
        cur_path.add(beginWord);
        buildString(map, result, cur_path, beginWord, endWord);
        return result;
    }

    private void buildMap(HashMap<String, List<String>> map, Set<String> start, Set<String> end, Set<String> dict, boolean reverse) {
        if (start.isEmpty()) {
            return;
        }

        if (start.size() > end.size()) {
            buildMap(map, end, start, dict, !reverse);
            return;
        }

        boolean finish = false;
        Set<String> next = new HashSet<>();
        dict.removeAll(start);
        for (String old_word : start) {
            char[] array = old_word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char old_i = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String new_word = String.valueOf(array);
                    if (dict.contains(new_word)) {
                        if (end.contains(new_word)) {
                            finish = true;
                        } else {
                            next.add(new_word);
                        }
                        String key = reverse ? new_word : old_word;
                        String value = reverse ? old_word : new_word;
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(value);
                    }
                }
                array[i] = old_i;
            }
        }
        if (!finish) {
            buildMap(map, next, end, dict, reverse);
        }
    }

    private void buildString(HashMap<String, List<String>> map, List<List<String>> result, List<String> cur_path, String begin, String end) {
        if (begin.equals(end)) {
            result.add(new ArrayList<>(cur_path));
            return;
        }

        if (!map.containsKey(begin)) {
            return;
        }

        for (String word : map.get(begin)) {
            cur_path.add(word);
            buildString(map, result, cur_path, word, end);
            cur_path.remove(cur_path.size() - 1);
        }
    }
}
