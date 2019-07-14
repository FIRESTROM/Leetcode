class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (z <= x + y && z % gcd(x, y) == 0);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
