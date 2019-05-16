class Solution {
    class helper_lst {
        List<Integer> list;
        int i = 0;
        helper_lst (List<Integer> list) {
            this.list = list;
        }
        boolean isEnd() {
            return i == list.size();
        }
        int get() {
            return list.get(i);
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0)
            return new int[2];

        int max_val = Integer.MIN_VALUE;
        PriorityQueue<helper_lst> pq = new PriorityQueue<helper_lst>(new Comparator<helper_lst>() {
            public int compare(helper_lst a, helper_lst b){
                return a.get() - b.get();
            }
        });

        for (List<Integer> list : nums) {
            if (list == null || list.size() == 0) return new int[2];
            if (list.get(0) > max_val) max_val = list.get(0);
            helper_lst temp = new helper_lst(list);
            pq.add(temp);
        }
        int min_val = pq.peek().get();
        int diff = Math.abs(min_val - max_val);
        int[] result = new int[] {min_val, max_val};
        while (pq.size() == nums.size()) {
            helper_lst temp = pq.poll();
            temp.i++;
            if (!temp.isEnd()) {
                pq.offer(temp);
                min_val = pq.peek().get();
                max_val = Math.max(max_val, temp.get());

                if (diff > Math.abs(min_val - max_val)) {
                    result[0] = min_val;
                    result[1] = max_val;
                    diff = Math.abs(min_val - max_val);
                }
            }
        }
        return result;
    }
}
