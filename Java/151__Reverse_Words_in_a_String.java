class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0) {
                sb.append(strings[i]);
                if (i > 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
