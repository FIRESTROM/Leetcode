class Solution {
    public String reverseWords(String s) {
        int start = 0, end = 0;
        while (end < s.length()) {
            int idx = s.indexOf(" ", start);
            if (idx == -1) break;
            s = reverse(s, start, idx - 1);
            start = idx + 1;
            end = start;
        }
        s = reverse(s, start, s.length() - 1);
        return s;
    }

    private String reverse(String s, int start, int end) {
        if (start > end) return s;
        char[] s_arr = s.toCharArray();
        while (start < end) {
            char temp = s_arr[start];
            s_arr[start] = s_arr[end];
            s_arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(s_arr);
    }
}

// Faster with StringBuilder
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }

        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new StringBuilder(strings[i]).reverse().toString();
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String str : strings) {
            resultBuilder.append(str).append(" ");
        }

        return resultBuilder.toString().trim();
    }
}
