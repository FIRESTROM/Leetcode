class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        int[] lst = new int[26];
        char[] str = s.toCharArray();
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j < s.length()) {
                lst[str[j] - 'A']++;
                if (count(lst) > k) {
                    lst[str[j] - 'A']--;
                    break;
                }
                j++;
            }
            result = Math.max(result, j - i);
            lst[str[i] - 'A']--;
        }
        return result;
    }

    public int count(int[] lst){
        int max_val = 0, sum = 0;
        for(int val : lst){
            sum += val;
            max_val = Math.max(max_val, val);
        }
        return sum - max_val;
    }
}
