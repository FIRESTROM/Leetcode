class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int K, int N) {
        if (!map.containsKey(N * 100 + K)) {
            int count;
            if (N == 0)
                count = 0;
            else if (K == 1)
                count = N;
            else {
                int l = 1, r = N;
                while (l + 1 < r) {
                    int mid = (l + r) / 2;
                    int val1 = dp(K - 1, mid - 1), val2 = dp(K, N - mid);
                    if (val1 < val2)
                        l = mid;
                    else if (val1 > val2)
                        r = mid;
                    else
                        l = r = mid;
                }
                count = 1 + Math.min(Math.max(dp(K - 1, l - 1), dp(K, N - l)), Math.max(dp(K - 1, r - 1), dp(K, N - r)));
            }

            map.put(N * 100 + K, count);
        }

        return map.get(N * 100 + K);
    }
}
