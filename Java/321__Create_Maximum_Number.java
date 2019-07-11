class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, result, 0))
                result = candidate;
        }
        return result;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            result[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return result;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (n - i + idx > k && idx > 0 && result[idx - 1] < nums[i])
                idx--;
            if (idx < k) result[idx++] = nums[i];
        }
        return result;
    }
}
