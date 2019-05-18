class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder newline = new StringBuilder();
        boolean commented = false;
        for (String s : source) {
            int i = 0;
            char[] s_arr = s.toCharArray();
            if (!commented) newline = new StringBuilder();
            while (i < s.length()) {
                if (!commented && i + i < s.length() && s_arr[i] == '/' && s_arr[i + 1] == '*') {
                    commented = true;
                    i++;
                } else if (commented && i + 1 < s.length() && s_arr[i] == '*' && s_arr[i + 1] == '/') {
                    commented = false;
                    i++;
                } else if (!commented && i + 1 < s.length() && s_arr[i] == '/' && s_arr[i + 1] == '/') {
                    break;
                } else if (!commented) {
                    newline.append(s_arr[i]);
                }
                i++;
            }
            if (!commented && newline.length() > 0) {
                result.add(new String(newline));
            }
        }
        return result;
    }
}
