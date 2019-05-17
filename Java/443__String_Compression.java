class Solution {
    public int compress(char[] chars) {
        int result = 0, idx = 0;
        while (idx < chars.length){
            char currentChar = chars[idx];
            int count = 0;
            while (idx < chars.length && chars[idx] == currentChar) {
                idx++;
                count++;
            }
            chars[result++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
        }
        return result;
    }
}
