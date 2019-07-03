// Boyer-Moore majority vote algorithm
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int len = nums.length;
        int firstCandidate = 0, secondCandidate = 1;
        int firstCandidateCount = 0, secondCandidateCount = 0;
        for (int candidate : nums) {
            if (candidate == firstCandidate) {
                firstCandidateCount++;
                continue;
            }
            if (candidate == secondCandidate) {
                secondCandidateCount++;
                continue;
            }
            if (firstCandidateCount == 0) {
                firstCandidate = candidate;
                firstCandidateCount++;
                continue;
            }
            if (secondCandidateCount == 0) {
                secondCandidate = candidate;
                secondCandidateCount++;
            } else {
                firstCandidateCount--;
                secondCandidateCount--;
            }
        }
        firstCandidateCount = 0;
        secondCandidateCount = 0;
        for (int candidate : nums) {
            if (candidate == firstCandidate) {
                firstCandidateCount++;
            }
            if (candidate == secondCandidate) {
                secondCandidateCount++;
            }
        }
        if (firstCandidateCount > len / 3) {
            results.add(firstCandidate);
        }
        if (secondCandidateCount > len / 3) {
            results.add(secondCandidate);
        }
        return results;
    }
}
