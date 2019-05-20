class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size =  (matrix[0].length * matrix.length) - (k - 1);
        for (int[] row : matrix) {
            for (int i : row) {
                pq.add(i);
                if (pq.size() > size)
                    pq.poll();
            }
        }
        return pq.peek();

    }
}

// Binary Search
class Solution {
     public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = (right + left) / 2;
            int num = count(matrix, mid);
            if (num >= k)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int result = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                result += i + 1;
                j++;
            } else
                i--;
        }
        return result;
    }
}
