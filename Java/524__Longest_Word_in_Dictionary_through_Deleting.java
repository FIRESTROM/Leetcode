class Solution {

    public String findLongestWord(String s, List < String > d) {
        String result = "";
        for (String str: d) {
            if (helper(str, s)) {
                if (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0))
                    result = str;
            }
        }
        return result;
    }

    private boolean helper(String str, String s) {
        int j = 0;
        for (int i = 0; i < s.length() && j < str.length(); i++)
            if (str.charAt(j) == s.charAt(i))
                j++;
        return j == str.length();
    }
}
