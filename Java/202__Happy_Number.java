class Solution {
    public boolean isHappy(int n) {
        while (true) {
            int next_n = helper(n);
            if (next_n == n) {
                break;
            }
            if (next_n == 4) {
                return false;
            }
            n = next_n;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int helper(int val) {
        int result = 0;
        while (val != 0) {
            int remain = val % 10;
            result += remain * remain;
            val /= 10;
        }
        return result;
    }
}
