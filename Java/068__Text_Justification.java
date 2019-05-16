class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int cur_len = 0, words_len = 0, start = 0;
        for (int i = 0; i < words.length; i++) {
            if (cur_len + words[i].length() <= maxWidth) {
                cur_len += words[i].length() + 1;
                words_len += words[i].length();
            } else { // unable to add ith word
                String cur = "";
                int end = i - 1;
                if (start == end) {
                    cur += words[start];
                    for (int k = 0; k < maxWidth - words[start].length(); k++) cur += " ";
                } else {
                    int space = (maxWidth - words_len) / (end - start);
                    int extra = (maxWidth - words_len) % (end - start);
                    for (int idx = start; idx < end; idx++) {
                        cur += words[idx];
                        for (int k = 0; k < space; k++) cur += " ";
                        if (idx <= start + extra - 1) cur += " ";
                    }
                    cur += words[end];
                }
                result.add(cur);
                cur_len = words[i].length() + 1;
                words_len = words[i].length();
                start = i;
            }
        }
        // Add last line : start : words.length - 1
        String last_line = "";
        for (int idx = start; idx < words.length - 1; idx++) {
            last_line += words[idx] + " ";
        }
        last_line += words[words.length - 1];
        while (last_line.length() < maxWidth) last_line += " ";
        result.add(last_line);
        return result;

    }
}
