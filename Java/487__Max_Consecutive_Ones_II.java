class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int prev = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else if (prev == -1) {
                prev = i;
                count++;
            } else {
                count = i - prev;
                prev = i;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}


// Another Solution
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int flippedCounter = -1;
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else {
                if (flippedCounter == -1) flippedCounter = count++;
                else {
                    count = count - flippedCounter;
                    flippedCounter = count - 1;
                }
            }
            result = Math.max(result, count);
        }
        return Math.max(result, count);
    }
}
