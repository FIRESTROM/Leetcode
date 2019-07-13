class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int remainder = n % 3;
        if (remainder == 0)
            return (int) Math.pow(3, (n / 3));
        if (remainder == 1)
            return (int) Math.pow(3, (n / 3 - 1)) * 4;
        if (remainder == 2)
            return (int) Math.pow(3, (n / 3)) * 2;
        return 0;
    }
}
