class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int result = 0;
        int cnt = 0;
        while (cnt < 32) {
            int c = a & 1, d = b & 1;
            result = result | ((c ^ d ^ carry) << cnt);
            a = a >> 1;
            b = b >> 1;
            carry = ((c & d) == 1 || (c & carry) == 1 || (d & carry) == 1) ? 1 : 0;
            cnt++;
        }
        if (cnt < 32)
            result = (result | (carry << cnt));
        return result;
    }
}
