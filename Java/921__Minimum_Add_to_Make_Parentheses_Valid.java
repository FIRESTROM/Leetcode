class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty()) result++;
                else stack.pop();
            }
        }
        result += stack.size();
        return result;
    }
}
