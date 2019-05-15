class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (!map.containsKey(S.charAt(i))) map.put(S.charAt(i), i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < S.length()) {
            int old_i = i;
            j = map.get(S.charAt(i));
            while (i <= j) {
                if (map.get(S.charAt(i)) > j) j = map.get(S.charAt(i));
                i++;
            }
            result.add(j - old_i + 1);
        }
        return result;
    }
}
