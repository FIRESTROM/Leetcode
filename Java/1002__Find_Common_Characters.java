class Solution {
    public List<String> commonChars(String[] A) {
        boolean first = true;
        int[] check = new int[26];
        for (String s : A) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            if (first) {
                check = temp;
                first = false;
            } else {
                for (int i = 0; i < 26; i++) {
                    check[i] = Math.min(check[i], temp[i]);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < check.length; i++)
            for (int cnt = 0; cnt < check[i]; cnt++)
                result.add(Character.toString((char) (i + 'a')));

        return result;
    }
}
