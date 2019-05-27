class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int prev = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while (idx < preorder.length || !stack.isEmpty()) {
            if (stack.isEmpty() || (idx < preorder.length && preorder[idx] < stack.peek())) {
                   stack.push(preorder[idx]);
                   idx++;
            } else {
                if (stack.peek() <= prev) {
                    return false;
                } else {
                    prev = stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
}
