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

// Quick Sort
class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if (a < b) {
            int index = pivot(nums, start, end);
            sort(nums, start, pivot - 1);
            sort(nums, pivot + 1, end);
        }
    }

    private int pivot(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start, j = end - 1;
        while (i <= j) {
            if(nums[i] > pivot) {
                swap(nums, i, j--);
            } else {
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
