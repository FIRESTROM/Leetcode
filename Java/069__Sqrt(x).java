class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0)
            return x;
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r) / 2;
            long cur = (long) mid * (long) mid;
            long next = (long) (mid + 1) * (long) (mid + 1);
            if (x == cur || (cur < x && next > x))
                return mid;
            if (cur > x) {
                r = mid - 1;
            } else if (mid * mid < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
