class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) return false;
        int i = 0, base = 0;
        while (i + 4 <= x.length) {
            if (x[i] - x[i + 2] >= 0 && x[i + 1] - x[i + 3] <= base) return true;
            else if (x[i + 1] - x[i + 3] > base) base = 0;
            else base = x[i];
            i++;
        }
        return false;
    }
}
