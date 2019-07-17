class Solution {

    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
        	if (!map.containsKey(nums[i]))
        		map.put(nums[i], new ArrayList<Integer>());
        	map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
    	return map.get(target).get(new Random().nextInt(map.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
