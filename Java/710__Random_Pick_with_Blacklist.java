class Solution {

    int n;
    int[] black;
    Random r;
    public Solution(int N, int[] blacklist) {
        n = N;
        Arrays.sort(blacklist);
        black = blacklist;
        r = new Random();
    }

    public int pick() {
        int k = r.nextInt(n - black.length);
        int l = 0, r = black.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int count = black[mid] - mid;
            if (count > k)
                r = mid - 1;
            else
                l = mid;
        }
        return l == r && black[l] - l <= k ? k + l + 1 : k;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
