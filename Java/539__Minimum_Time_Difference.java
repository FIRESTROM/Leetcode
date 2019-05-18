class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for (String str : timePoints) {
            time.add(transfer(str));
        }
        Collections.sort(time, (a, b) -> a - b);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < time.size(); i++) {
            result = Math.min(result, time.get(i) - time.get(i - 1));
        }
        result = Math.min(result, time.get(0) + (1440 - time.get(time.size() - 1)));
        return result;
    }

    private int transfer(String str) {
        String[] str_arr = str.split(":");
        int result = Integer.parseInt(str_arr[0]) * 60 + Integer.parseInt(str_arr[1]);
        return result;
    }
}

        
