class Solution {
    public int calculate(String s) {
        s = s.trim().replace(" ", "");
        s += "+";
        int val = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                val = val * 10 + s.charAt(i) - '0';
            } else {
                if (sign == '+') {
                    stack.push(val);
                } else if (sign == '-') {
                    stack.push(-1 * val);
                } else if (sign == '*') {
                    stack.push(stack.pop() * val);
                } else if (sign == '/') {
                    stack.push(stack.pop() / val);
                }
                val = 0;
                sign = s.charAt(i);
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
