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

// Much Simpler Solution
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
