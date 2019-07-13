class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int result = 10;
        int availableDigits = 9;
        int uniqueDigits = 9;
        while (n-- > 1 && availableDigits > 1) {
            uniqueDigits *= availableDigits;
            result += uniqueDigits;
            availableDigits--;
        }
        return result;
    }
}
