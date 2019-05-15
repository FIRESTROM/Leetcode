class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        ArrayList<int[]> result_arr = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (Math.max(A[i][0], B[j][0]) <= Math.min(A[i][1], B[j][1])) {
                int[] temp = {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])};
                result_arr.add(temp);
            }
            if (A[i][1] > B[j][1]) {
                j++;
            } else if (A[i][1] < B[j][1]) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        i = 0;
        int[][] result = new int[result_arr.size()][2];
        for (int[] temp : result_arr) {
            result[i] = temp;
            i++;
        }
        return result;
    }
}
