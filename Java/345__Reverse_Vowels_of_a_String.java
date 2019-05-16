class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        char[] s_arr = s.toCharArray();
        while (i < j) {
            while (i < j && !vowel.contains(s_arr[i])) i++;
            while (i < j && !vowel.contains(s_arr[j])) j--;
            char temp = s_arr[i];
            s_arr[i] = s_arr[j];
            s_arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(s_arr);

    }
}
