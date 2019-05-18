class Solution {

    class MultiChar {
        int count;
        char letter;
        MultiChar (int cnt, char c) {
            count = cnt;
            letter = c;
        }
    }
    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c: S.toCharArray()) count[c - 'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
            a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (N + 1) / 2) return "";
                pq.add(new MultiChar(count[i], (char) ('a' + i)));
            }
        }

        StringBuilder result = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar temp1 = pq.poll();
            MultiChar temp2 = pq.poll();
            result.append(temp1.letter);
            result.append(temp2.letter);
            if (--temp1.count > 0) pq.add(temp1);
            if (--temp2.count > 0) pq.add(temp2);
        }

        if (pq.size() > 0) result.append(pq.poll().letter);
        return result.toString();
    }
}
