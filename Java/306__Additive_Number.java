class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() / 2; i++)
            for (int j = i + 1; j - i <= num.length() / 2; j++)
                if (helper(num, 0, i, i + 1, j))
                    return true;
        return false;
    }

    private boolean helper(String num, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        long first = Long.parseLong(num.substring(firstStart, firstEnd + 1));
        long second = Long.parseLong(num.substring(secondStart, secondEnd + 1));
        if (((num.charAt(firstStart) == '0') && (firstEnd - firstStart > 0)) || ((num.charAt(secondStart) == '0') && (secondEnd - secondStart>0)))
            return false;
        String sum = String.valueOf(first + second);
        int sumEndIndex = secondEnd + sum.length();
        if ((sumEndIndex < num.length()) && sum.equals(num.substring(secondEnd + 1,sumEndIndex + 1))) {
            if (sumEndIndex == num.length() - 1)
                return true;
            else
                return helper(num, secondStart, secondEnd, secondEnd + 1, sumEndIndex);
        } else
            return false;
    }
}
