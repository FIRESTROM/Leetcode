class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] str_arr = str.split(" ");
        System.out.println(str_arr.length);
        if (str_arr.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(str_arr[i]))
                    return false;
            } else {
                if (map.containsValue(str_arr[i]))
                    return false;
                map.put(c, str_arr[i]);
            }
        }
        return true;
    }
}
