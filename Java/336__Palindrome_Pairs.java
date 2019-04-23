class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        if (map.containsKey("")) {
            int index = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != index && isPalindrome(words[i])) {
                    result.add(Arrays.asList(i, index));
                    result.add(Arrays.asList(index, i));
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            String rev = reverseString(words[i]);
            if (map.containsKey(rev) && map.get(rev) != i) {
                result.add(Arrays.asList(i, map.get(rev)));
            }
        }
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                if (isPalindrome(cur.substring(0, cut))) {
                    String cut_rev = reverseString(cur.substring(cut));
                    if (map.containsKey(cut_rev) && map.get(cut_rev) != i) {
                        result.add(Arrays.asList(map.get(cut_rev), i));
                    }
                }
                if (isPalindrome(cur.substring(cut))) {
                    String cut_rev = reverseString(cur.substring(0, cut));
                    if (map.containsKey(cut_rev) && map.get(cut_rev) != i) {
                        result.add(Arrays.asList(i, map.get(cut_rev)));
                    }
                }
            }
        }
        return result;

    }

    private String reverseString(String str) {
        StringBuilder rev = new StringBuilder(str);
        return rev.reverse().toString();
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
