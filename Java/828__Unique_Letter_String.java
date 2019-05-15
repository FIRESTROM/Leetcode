class Solution {
    public int uniqueLetterString(String S) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(c, temp);
            }
        }

        long result = 0;
        for (List<Integer> A: map.values()) {
            for (int i = 0; i < A.size(); i++) {
                long prev = i > 0 ? A.get(i - 1) : -1;
                long next = i < A.size() - 1 ? A.get(i + 1) : S.length();
                result += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) result % 1_000_000_007;
    }
}
