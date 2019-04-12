class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int cur_height = 0;
        int all_space = 0;
        while (left <= right) {
            if (left == right) {
                all_space += height[left] - cur_height;
                break;
            }
            if (height[left] < height[right]) {
                all_space += (height[left] - cur_height) * (right - left + 1);
                cur_height = height[left];
            } else {
                all_space += (height[right] - cur_height) * (right - left + 1);
                cur_height = height[right];
            }
            while (left < right && height[left] <= cur_height) {
                left += 1;
            }
            while (left < right && height[right] <= cur_height) {
                right -= 1;
            }
        }
        for (int val : height) {
            all_space -= val;
        }
        return all_space;
    }
}
