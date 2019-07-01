class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int count = 0;
        while (m > 0 && n > 0) {
            if (m == n && (m & 1) == 1)
                result = (1 << count) | result;
            count++;
            m >>= 1;
            n >>= 1;
        }
        return result;
    }
}
