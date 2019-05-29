class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = Integer.toString(nums[i]);
        Arrays.sort(strs, new newComparator());
        if (strs[0].equals("0"))
            return "0";
        String result = new String();
        for (String str : strs)
            result += str;
        return result;
    }

    private class newComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}
