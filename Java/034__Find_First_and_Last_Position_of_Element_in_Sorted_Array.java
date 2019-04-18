class Solution {

    public int[] searchRange(int[] nums, int target) {
    		int start = firstGreaterEqual(nums, target);
    		if (start == nums.length || nums[start] != target) {
      			return new int[]{-1, -1};
    		}
    		return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};
	}

	//find the first number that is greater than or equal to target.
	//could return A.length if target is greater than A[A.length-1].
	//actually this is the same as lower_bound in C++ STL.
	private static int firstGreaterEqual(int[] nums, int target) {
		int low = 0, high = nums.length;
		while (low < high) {
			int mid = (low + high) / 2;
			//low <= mid < high
			if (nums[mid] < target) {
				low = mid + 1;
			} else {
				//should not be mid-1 when A[mid]==target.
				//could be mid even if A[mid]>target because mid<high.
				high = mid;
			}
		}
		return low;
    }
}
