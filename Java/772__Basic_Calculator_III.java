class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        Queue<Character> queue = new LinkedList<>();
        s = s.replace(" ", "");
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        queue.offer('+');
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = helper(queue);
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
