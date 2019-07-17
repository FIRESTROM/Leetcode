class Solution {

    String result = "";
	int min = Integer.MAX_VALUE;
	String[] dict;

    public String minAbbreviation(String target, String[] dictionary) {
        if (dictionary.length == 0) return "" + target.length();
        dict = dictionary;
    	generateAbbreviations(target.toCharArray(), 0, new StringBuilder(), 0, 0);
    	return result;
    }
    //check if it's a valid unique abbreviation after building an abbreviation
    private void check (String abbr, int length) {
		for (String word: dict) {
			if (validWordAbbreviation(word, abbr)) return;
		}
		min = length;
		result = abbr;
    }
    //basically backtracking implementation of Generalized Abbreviation, but adding a length
    private void generateAbbreviations(char[] s, int pos, StringBuilder sb, int abb, int length){
        //prune out those abbreviations longer than our current shortest unique abbreviation
        if (length >= min) {
            return;
        } else if (s.length == pos) {
            if (abb > 0) {
            	if (length + 1 < min) check(sb.toString()+abb, length+1);
            } else {
            	check(sb.toString(), length);
            }
        } else {
            int l = sb.length();
            generateAbbreviations(s, pos+1, sb, abb+1, length);
            if (abb > 0) {
                sb.append(abb);
                abb = 0;
                length++;
            }
            sb.append(s[pos]);
            generateAbbreviations(s, pos+1, sb, 0, length+1);
            sb.setLength(l);
        }
    }

    //from 408 Valid Word Abbreviation
    private boolean validWordAbbreviation(String word, String abbr) {
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();
        int widx = 0;
        int aidx = 0;
        while (widx < w.length && aidx < a.length) {
            if ('a' <= a[aidx]  && a[aidx] <= 'z') {
                if (a[aidx++] != w[widx++]) return false;
            } else if ('1' <= a[aidx] && a[aidx] <= '9'){
                int val = a[aidx++] - '0';
                while (aidx < a.length && '0' <= a[aidx] && a[aidx] <= '9') val = val * 10 + a[aidx++] - '0';
                widx += val;
            } else {
                return false;
            }
        }
        return aidx == a.length && widx == w.length;
    }
}
