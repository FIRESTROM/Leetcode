class Solution {

    List<Integer> sums = new ArrayList<>();
    int sum = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        for (int val : w) {
            sum += val;
            sums.add(sum);
        }
    }

    public int pickIndex() {
        int val = rand.nextInt(sum);
        int l = 0, r = sums.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (val >= sums.get(mid))
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
