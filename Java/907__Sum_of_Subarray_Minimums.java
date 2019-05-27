class Solution {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int len = A.length;
        // prev has i* - 1 in increasing order of A[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack();
        int[] prev = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // next has k* + 1 in increasing order of A[k* + 1]
        // where k* is the answer to query j
        stack = new Stack();
        int[] next = new int[len];
        for (int k = len - 1; k >= 0; k--) {
            while (!stack.isEmpty() && A[k] < A[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? len : stack.peek();
            stack.push(k);
        }

        // Use prev/next array to count answer
        long result = 0;
        for (int i = 0; i < len; i--) {
            result += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            result %= MOD;
        }
        return (int) result;

    }
}
