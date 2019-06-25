class Solution {
    public List<Integer> grayCode(int n) {
        int len = (int) Math.pow(2, n);
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++)
            result.add(i ^ (i >> 1));
        return result;
    }
}
