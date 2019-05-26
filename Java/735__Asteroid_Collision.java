class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        if (asteroids == null || asteroids.length == 0)
            return null;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            int cur_val = asteroids[i];
            if (cur_val > 0) {
                stack.push(cur_val);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -1 * cur_val)
                stack.pop();
            if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -1 * cur_val) {
                stack.pop();
                continue;
            }
            if (stack.isEmpty() || stack.peek() < 0)
                stack.push(cur_val);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
