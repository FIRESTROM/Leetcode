class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend > Integer.MAX_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (ldividend == 0 || ldividend < ldivisor || ldivisor == 0)
            return 0;
        int result = 0;
        while (ldividend >= ldivisor) {
            long sum = ldivisor;
            long multiple = 1;
            while (sum + sum <= ldividend) {
                sum += sum;
                multiple += multiple;
            }
            result += multiple;
            ldividend -= sum;
        }
        return result * sign;
    }
}
