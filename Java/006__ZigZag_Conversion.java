class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;
        HashMap<Integer, String> map = new HashMap<>();
        int idx = 0, dir = 1;
        for (char c : s.toCharArray()) {
            idx += dir;
            if (!map.containsKey(idx)) map.put(idx, new String());
            String temp = map.get(idx);
            temp += String.valueOf(c);
            map.put(idx, temp);
            if (idx == numRows) dir = -1;
            if (idx == 1) dir = 1;
        }
        String result = "";
        for (int i = 1; i <= numRows; i++) {
            if (map.get(i) != null) result += map.get(i);
        }
        return result;
    }
}
