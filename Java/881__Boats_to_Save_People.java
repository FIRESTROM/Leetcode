class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int result = 0;
        while (i <= j) {
            if (i == j) {
                result++;
                break;
            }
            if (people[i] + people[j] <= limit) {
                result++;
                i++;
                j--;
            } else {
                result++;
                j--;
            }
        }
        return result;
    }
}
