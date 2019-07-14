class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        // Iterate updates and use answer array to store two-end info.
        for (int[] update : updates) {
            int l_pos = update[0], r_pos = update[1];
            result[l_pos] += update[2];
            // Keep update in the range by removing the increment after.
            if (r_pos < length - 1) {
                // Ignore the rightmost update.
                result[r_pos + 1] -= update[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
