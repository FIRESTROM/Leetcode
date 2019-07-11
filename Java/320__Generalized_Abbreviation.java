public class Solution {

    List<String> result;

    public List<String> generateAbbreviations(String word){
        result = new ArrayList<String>();
        backtrack(new StringBuilder(), word, 0, 0);
        return result;
    }

    private void backtrack(StringBuilder builder, String word, int idx, int count) {
        int len = builder.length();
        if (idx == word.length()) {
            if (count != 0) builder.append(count);
            result.add(builder.toString());
        } else {
            backtrack(builder, word, idx + 1, count + 1);
            if (count != 0) builder.append(count);
            builder.append(word.charAt(idx));
            backtrack(builder, word, idx + 1, 0);
        }
        builder.setLength(len);
    }
}
