class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        String result = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = 0;
                while (Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(val);
            } else if (c == '[') {
                strs.push(result);
                result = "";
                i++;
            } else if (c == ']') {
                String last_str = strs.pop();
                int last_val = nums.pop();
                StringBuilder temp = new StringBuilder(last_str);
                for (int j = 0; j < last_val; j++){
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            } else {
                result += c;
                i++;
            }
        }

        return result;
    }
}

    
