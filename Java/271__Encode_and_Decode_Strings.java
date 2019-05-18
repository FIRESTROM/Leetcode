public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result += Integer.toString(str.length()) + "|" + str;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (s.charAt(right) == '|') {
                int len = Integer.valueOf(s.substring(left, right));
                result.add(s.substring(right + 1, right + len + 1));
                left = right + len + 1;
                right = left;
            }
            right++;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
