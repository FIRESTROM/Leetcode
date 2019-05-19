class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double temp = myPow(x, n / 2);

        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return n > 0 ? temp * temp * x : temp * temp * (1/x);
        }
    }
}
