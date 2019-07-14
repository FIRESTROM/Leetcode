class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] sizes = new int[nums.length];
        int[] prevs = new int[nums.length];
        int maxidx = 0;
        for (int i = 0; i < nums.length; i++) {
            sizes[i] = 1;
            prevs[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && sizes[i] < sizes[j] + 1) {
                    sizes[i] = sizes[j] + 1;
                    prevs[i] = j;
                }
            }
            if (sizes[i] > sizes[maxidx]) maxidx = i;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = maxidx; i != -1; i = prevs[i]) {
            list.add(nums[i]);
        }
        return list;
    }
}
