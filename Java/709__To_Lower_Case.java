class Solution {
    public String toLowerCase(String str) {

        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                s.setCharAt(i, (char) ((int) str.charAt(i) + 32));
            }
        }
        return s.toString();
    }
}
