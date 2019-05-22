class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int len = num.length();
        for (int i = 0; i <= len / 2; i++) {
            if (!map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(len - i - 1))
                return false;
        }
        return true;

    }
}
