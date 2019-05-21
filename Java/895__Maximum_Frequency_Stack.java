class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int max_freq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        max_freq = 0;
    }

    public void push(int x) {
        int cur_freq = freq.getOrDefault(x, 0) + 1;
        freq.put(x, cur_freq);
        if (cur_freq > max_freq)
            max_freq = cur_freq;
        group.computeIfAbsent(cur_freq, z->new Stack()).push(x);
    }

    public int pop() {
        int val = group.get(max_freq).pop();
        freq.put(val, freq.get(val) - 1);
        if (group.get(max_freq).size() == 0) {
            max_freq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
