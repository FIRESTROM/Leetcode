class Solution {
    class Pair implements Comparable<Pair> {
        int idx1;
        int idx2;
        int sum;
        Pair(int idx1, int idx2, int sum) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = sum;
        }

        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // 0(n*logn) ; n is the length of the smaller array among them
        for (int i = 0; i < nums2.length; i++)
            pq.add(new Pair(0, i, nums1[0] + nums2[i]));
        List<List<Integer>> result = new ArrayList<>();
        while (k-- > 0 && pq.size() > 0) {
            Pair cur_pair = pq.remove();
            result.add(Arrays.asList(nums1[cur_pair.idx1], nums2[cur_pair.idx2]));
            if (cur_pair.idx1 == nums1.length - 1) continue;
            else pq.add(new Pair(cur_pair.idx1 + 1, cur_pair.idx2, nums1[cur_pair.idx1 + 1] + nums2[cur_pair.idx2]));
        }
        return result;
    }
}
