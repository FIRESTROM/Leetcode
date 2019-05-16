class Solution {
    public String pushDominoes(String dominoes) {
        char[] s_arr = dominoes.toCharArray();
        int start = 0;
        for (int i = 1; i < s_arr.length; i++) {
            if (s_arr[i] == 'L') {
                process(s_arr, start, i);
                start = i + 1;
            } else if (s_arr[i] == 'R') {
                process(s_arr, start, i - 1);
                start = i;
            }
        }

        process(s_arr, start, s_arr.length - 1);

        return new String(s_arr);
    }

    private void process(char[] s_arr, int start, int end) {
        if (start >= s_arr.length || end >= s_arr.length || start >= end) return;

        if (s_arr[start] == 'R' && s_arr[end] == 'L') {
            while (start < end) {
                s_arr[start] = 'R';
                s_arr[end] = 'L';
                end--;
                start++;
            }

        } else if (s_arr[end] == 'L') {

            while (end >= start) {
                s_arr[end] = 'L';
                end--;
            }

        } else if (s_arr[start] == 'R') {
            while (start <= end) {
                s_arr[start] = 'R';
                start++;
            }
        }

    }


}
