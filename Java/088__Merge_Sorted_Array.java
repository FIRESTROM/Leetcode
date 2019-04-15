class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer_1 = m - 1, pointer_2 = n - 1;
        int pointer = m + n - 1;
        while (pointer_1 >= 0 && pointer_2 >= 0) {
            nums1[pointer--] = (nums1[pointer_1] < nums2[pointer_2]) ? nums2[pointer_2--] : nums1[pointer_1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, pointer_2 + 1);
    }
}
