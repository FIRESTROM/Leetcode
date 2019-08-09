class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
		for (int w : weights) {
			left = Math.max(left, w);
			right += w;
		}
		while (left < right) {
			int mid = (left + right) / 2;
			int capacity = 0, need = 1;
			for (int weight : weights) {
				if (capacity + weight > mid) {
					need ++;
					capacity = 0;
				}
				capacity += weight;
			}
			if (need > D) left = mid + 1;
			else right = mid;
		}
		return left;
    }
}
