class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums1) {
            set.add(val);
        }
        ArrayList<Integer> result_array = new ArrayList<>();
        for (int val : nums2) {
            if (!result_array.contains(val) && set.contains(val)) {
                result_array.add(val);
            }
        }
        int[] result = new int[result_array.size()];
        int i = 0;
        for (int val : result_array) {
            result[i] = val;
            i++;
        }
        return result;
    }
}

// Similar Solution
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result_set = new HashSet<>();
        for (int num :nums1) {
            set.add(num);
        }
        for (int num :nums2) {
            if (set.contains(num)) {
              result_set.add(num);
            }
        }
        int [] result = new int [result_set.size()];
        int i = 0;
        for (int val : result_set){
            result[i++] = val;
        }
        return result;
    }
}
