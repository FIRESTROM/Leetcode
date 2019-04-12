class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        int totalsize = nums1.length + nums2.length;
        int index_1 = 0, index_2 = 0;
        while (index_1 + index_2 < totalsize / 2 - 1) {
            if (index_1 < nums1.length && index_2 < nums2.length) {
                if (nums1[index_1] < nums2[index_2]) {
                    index_1 += 1;
                } else {
                    index_2 += 1;
                }
            } else if (index_1 == nums1.length) {
                index_2 += 1;
            } else {
                index_1 += 1;
            }
        }
        int[] result = new int[2];
        int i = 0;
        while (i < 2) {
            if (index_1 < nums1.length && index_2 < nums2.length) {
                if (nums1[index_1] < nums2[index_2]) {
                    result[i] = nums1[index_1];
                    index_1 += 1;
                } else {
                    result[i] = nums2[index_2];
                    index_2 += 1;
                }
            } else if (index_1 == nums1.length) {
                result[i] = nums2[index_2];
                index_2 += 1;
            } else {
                result[i] = nums1[index_1];
                index_1 += 1;
            }
            i += 1;
        }
        if (totalsize % 2 == 0) {
            return (result[0] + result[1]) / 2.0;
        } else {
            return result[1];
        }


    }
}
