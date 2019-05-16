class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 || typed.length() < name.length()) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (i == name.length() && typed.charAt(j) == name.charAt(i - 1)) {
                j++;
            }
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0 && typed.charAt(j - 1) == typed.charAt(j) && typed.charAt(j) == name.charAt(i - 1)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        if (i == name.length()) return true;
        else return false;
    }
}
