class Solution {
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);

        result[4] = findNext(result[4], (char) ('9' + 1), digits);
        if (result[4] > time.charAt(4)) return String.valueOf(result);

        result[3] = findNext(result[3], '5', digits);
        if (result[3] > time.charAt(3)) return String.valueOf(result);

        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
        if (result[1] > time.charAt(1)) return String.valueOf(result);

        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);

    }

    private char findNext(char current, char upperLimit, char[] digits) {
        if (current == upperLimit) {
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, current) + 1;
        while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) {
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
}
