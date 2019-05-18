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
        String result = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result += String.valueOf(count) + Character.toString(s.charAt(i - 1));
                count = 1;
            }
        }
        result += String.valueOf(count) + Character.toString(s.charAt(s.length() - 1));
        return result;
    }
}
