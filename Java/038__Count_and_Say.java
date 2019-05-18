class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            s = helper(s);
            n--;
        }
        return s;
    }

    private String helper(String s) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(s.charAt(s.length() - 1));
        return result.toString();
    }
}
