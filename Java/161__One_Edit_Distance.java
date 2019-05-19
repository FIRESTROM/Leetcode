class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length())
            return replace(s, t);
        else if (s.length() > t.length())
            return remove(s, t);
        else
            return remove(t, s);
    }

    private boolean replace(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                count++;
        }
        if (count != 1)
            return false;
        return true;
    }

    private boolean remove(String s, String t) {
        if (s.length() != (t.length() + 1))
            return false;
        for (int i = 0; i < s.length(); i++) {
            if ((s.substring(0, i) + s.substring(i + 1)).equals(t))
                return true;
        }
        return false;
    }
}
