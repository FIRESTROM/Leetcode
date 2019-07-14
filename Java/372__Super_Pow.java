class Solution {

    public int superPow(int a, int[] b) {
        a %= 1337;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * pow(a, b[i]) % 1337;
            a = pow(a, 10);
        }
        return result;
    }

    private int pow(int a, int b) {
        int result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
            result = result * a % 1337;
            }
            a = a * a % 1337;
            b /= 2;
        }
        return result;
    }
}
