class Solution {
    public int maximumSwap(int num) {
        char[] num_arr = Integer.toString(num).toCharArray();
        int[] last_idx = new int[10];
        for (int i = 0; i < num_arr.length; i++)
            last_idx[num_arr[i] - '0'] = i;
        for (int i = 0; i < num_arr.length; i++) {
            for (int d = 9; d > num_arr[i] - '0'; d--) {
                if (last_idx[d] > i) {
                    char temp = num_arr[i];
                    num_arr[i] = num_arr[last_idx[d]];
                    num_arr[last_idx[d]] = temp;
                    return Integer.valueOf(new String(num_arr));
                }
            }
        }
        return num;
    }
}
