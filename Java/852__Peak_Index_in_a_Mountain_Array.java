class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int l = 1, r = A.length - 2;
        while (l < r) {
            int mid = (l + r) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1])
                return mid;
            if (A[mid - 1] < A[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
