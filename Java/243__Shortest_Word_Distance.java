class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) pos1 = i;
            if (words[i].equals(word2)) pos2 = i;
            if (pos1 != -1 && pos2 != -1)
                result = Math.min(result, Math.abs(pos1 - pos2));
        }
        return result;
    }
}
