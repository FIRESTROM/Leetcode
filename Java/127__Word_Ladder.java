class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord))
            return 1;

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int cur_size = queue.size();

            for (int x = 0; x < cur_size; x++) {
                char[] cur_str = queue.poll().toCharArray();
                for (int i = 0; i < cur_str.length; i++) {
                    char temp = cur_str[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur_str[i] = c;
                        String result = new String(cur_str);
                        if (set.contains(result)) {
                            if (result.equals(endWord))
                                return level + 1;
                            queue.add(result);
                            set.remove(result);
                        }
                    }
                cur_str[i] = temp;
                }
            }
            level++;
        }

        return 0;
    }
}
