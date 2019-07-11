class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
		int [] words_bit = new int[len];
		int [] lenList = new int[len];
		int i = 0;
		for (String word : words) {
			for (char c : word.toCharArray())
				words_bit[i] |= (1 << (int) (c - 'a'));
			lenList[i] = word.length();
			i++;
		}
		int result = 0;
		for (i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++)
				if ((words_bit[i] & words_bit[j]) == 0)
					result = Math.max(result, lenList[i] * lenList[j]);
		return result;
    }
}
