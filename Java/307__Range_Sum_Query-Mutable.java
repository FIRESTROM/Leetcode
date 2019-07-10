class NumArray {

    int[] tree;
    int[] nums;
    int size;

    public NumArray(int[] nums) {
        this.size = nums.length;
        this.nums = new int[size];
        this.tree = new int[size];
        for (int i = 0; i < size; i++)
            update(i, nums[i]);
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        for (; i < size; i |= i + 1)
            tree[i] += delta;
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    public int sum(int ind) {
        int result = 0;
        while (ind >= 0) {
            result += tree[ind];
            ind &= ind + 1;
            ind--;
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
