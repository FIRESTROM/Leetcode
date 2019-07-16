class Solution {
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        int remaining = n;
        int head = 1, step = 1;
        boolean left = true;
        for(;;) {
            if (left || remaining % 2 == 1)
                head += step;
            remaining = remaining / 2;
            if (remaining == 1) break;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
