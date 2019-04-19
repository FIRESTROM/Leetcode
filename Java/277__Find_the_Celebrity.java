/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] num_i_know = new int[n];
        int[] known_by = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    num_i_know[i]++;
                    known_by[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (num_i_know[i] == 1) {
                if (known_by[i] == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}

// Smarter solution

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (knows(candidate, i) || !knows(i, candidate)) return -1;
        }

        return candidate;
    }
}
