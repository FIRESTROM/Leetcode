class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int i = 0, result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (count.size() > K) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) count.remove(A[i]);
                i++;
            }
            result += j - i + 1;
        }
        return result;
    }
}
