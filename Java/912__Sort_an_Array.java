class Solution {
    public int[] sortArray(int[] nums) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) list.add(new int[]{nums[i]});
        while (list.size() > 1) {
            ArrayList<int[]> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i = i + 2) {
                if (i == list.size() - 1) result.add(list.get(i));
                else {
                    int[] res = merge(list.get(i), list.get(i + 1));
                    result.add(res);
                }
            }
            list = result;
        }
        return list.get(0);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) result[i+j] = nums1[i++];
            else result[i+j] = nums2[j++];
        }
        for (; i < nums1.length; i++) result[i + j] = nums1[i];
        for (; j < nums2.length; j++) result[i + j] = nums2[j];
        return result;
    }
}
