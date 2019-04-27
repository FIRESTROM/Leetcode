class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                lst.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[lst.size()];
        i = 0;
        for (int val : lst) {
            result[i] = val;
            i++;
        }
        return result;
    }
}
