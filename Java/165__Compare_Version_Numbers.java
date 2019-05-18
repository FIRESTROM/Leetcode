class Solution {
    public int compareVersion(String version1, String version2) {
        return compare(cleaning(version1), cleaning(version2));
    }

    private int[] cleaning(String str) {
        String[] str_arr = str.split("\\.");
        int[] result = new int[str_arr.length];
        for (int i = 0; i < str_arr.length; i++) result[i] = Integer.parseInt(str_arr[i]);
        return result;
    }

    private int compare(int[] v1, int[] v2) {
        int i = 0;
        while (i < v1.length && i < v2.length) {
            if (v1[i] < v2[i]) return -1;
            else if (v1[i] > v2[i]) return 1;
            i++;
        }
        if (v1.length == v2.length) return 0;
        if (i < v1.length) {
            boolean all_zero = true;
            for (int k = i; k < v1.length; k++) if (v1[k] != 0) all_zero = false;
            return all_zero ? 0 : 1;
        } else {
            boolean all_zero = true;
            for (int k = i; k < v2.length; k++) if (v2[k] != 0) all_zero = false;
            return all_zero ? 0 : -1;
        }
    }
}
