class Solution {
    public int countDigitOne(int n) {
        String numstr = Integer.toString(n);
        return helper(n, numstr.length());
    }

    private int helper(int n, int len) {
        if (n < 1)  return 0;
        else if (len == 1) return 1;
        int pow = (int) Math.pow(10, len - 1);
        int msd = n / pow;
        if (msd == 0) return helper(n, len - 1);
        return (msd == 1 ? n % pow + 1 : pow) + helper(n % pow, len - 1) + msd * helper(pow - 1, len - 1);
    }
}
