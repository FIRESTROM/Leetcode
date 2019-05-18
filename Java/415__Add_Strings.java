class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int i = len1 - 1, j = len2 - 1;
        int addone = 0;
        String result = "";
        while (i >= 0 && j >= 0) {
            int val = addone + Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j));
            addone = val / 10;
            result = Integer.toString(val % 10) + result;
            i--;
            j--;
        }
        if (i == -1) {
            while (j >= 0) {
                int val = addone + Character.getNumericValue(num2.charAt(j));
                addone = val / 10;
                result = Integer.toString(val % 10) + result;
                j--;
            }
        } else {
            while (i >= 0) {
                int val = addone + Character.getNumericValue(num1.charAt(i));
                addone = val / 10;
                result = Integer.toString(val % 10) + result;
                i--;
            }
        }
        if (addone == 1) result = "1" + result;
        return result;
    }
}
