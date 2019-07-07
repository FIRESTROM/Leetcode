class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = citations.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (citations[mid] == n - mid) return n - mid;
            else if (citations[mid] < n - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}
