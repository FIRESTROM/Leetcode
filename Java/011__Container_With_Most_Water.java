class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return result;
    }
}
