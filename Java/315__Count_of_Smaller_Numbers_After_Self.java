class Solution {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int count = 1;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
            return result;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		result.add(0);
		for (int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			result.add(count);
		}
		Collections.reverse(result);
		return result;
    }

    private int insertNode(TreeNode root, int val) {
		int thisCount = 0;
		while (true) {
			if (val <= root.val) {
				root.count++;
				if (root.left == null) {
					root.left = new TreeNode(val);
                    break;
				} else {
					root = root.left;
				}
			} else {
				thisCount += root.count;
				if (root.right == null) {
					root.right = new TreeNode(val);
                    break;
				} else {
					root = root.right;
				}
			}
		}
		return thisCount;
	}
}
