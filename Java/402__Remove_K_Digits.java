class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";
        StringBuilder result = new StringBuilder(num);
        int i = 0;
        while (k > 0 && i < result.length() - 1) {
            if (result.charAt(i) > result.charAt(i + 1)) {
                result.deleteCharAt(i);
                k--;
                if (i > 0)
                    i--;
            } else
                i++;
        }
        while (result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);

        return result.substring(0, result.length() - k);
    }
}
