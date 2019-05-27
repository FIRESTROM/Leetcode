class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                stack.push(Integer.valueOf(token));
            } else {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(calculate(v2, v1, token));
            }
        }
        return stack.pop();
    }

    private int calculate(int v1, int v2, String operator) {
        switch (operator) {
            case "+":
                return v1 + v2;
            case "-":
                return v1 - v2;
            case "*":
                return v1 * v2;
            case "/":
                return v1 / v2;
        }
        return 0;
    }
}
