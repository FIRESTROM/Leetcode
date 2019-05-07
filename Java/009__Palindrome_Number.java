class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0, origin = x;
        while (origin != 0) {
            reverse = reverse * 10 + origin % 10;
            origin /= 10;
        }
        return reverse == x;
    }
}
