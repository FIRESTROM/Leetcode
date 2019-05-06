class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char[] s_arr = s.toCharArray();
        for (int i = 0; i < s_arr.length - 1; i++) {
            if (map.get(s_arr[i]) < map.get(s_arr[i + 1])) {
                result -= map.get(s_arr[i]);
            } else {
                result += map.get(s_arr[i]);
            }
        }
        result += map.get(s_arr[s_arr.length - 1]);
        return result;
    }
}
