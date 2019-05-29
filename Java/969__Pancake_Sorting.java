class Solution {

    List<Integer> result = new ArrayList<>();

    public List<Integer> pancakeSort(int[] A) {
        for (int i = A.length; i > 0; i--) {
            int max = 0;
            int max_idx = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] > max) {
                    max = A[j];
                    max_idx = j;
                }
            }
            flip(max_idx, i, A);
        }
        return result;
    }

    private void flip(int max_idx, int new_pos, int[] A) {
        int start = 0;
        int end = max_idx;
        swap(start, end, A);
        swap(start, new_pos - 1, A);
        result.add(max_idx + 1);
        result.add(new_pos);
    }

    private void swap(int start , int end, int[] A) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }


}
