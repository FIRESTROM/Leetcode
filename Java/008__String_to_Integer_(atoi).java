class Solution {
    public int myAtoi(String str) {
        int result = 0, sign = 1;
        boolean numberStared = false;

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                numberStared = true;
                int cur = c - '0';
                int new_result = result * 10 + cur;
                if (new_result < 0 || (new_result - cur) / 10 != result) {
                    return sign > 0 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                }
                result = new_result;
            } else if (c == '-' && !numberStared) {
                sign = -1;
                numberStared = true;
            } else if (c == '+' && !numberStared) {
                numberStared = true;
            } else if (c == ' ' && !numberStared) {
                continue;
            } else {
                break;
            }
        }
        return result * sign;
    }
}
