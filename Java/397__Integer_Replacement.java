class Solution {
    public int integerReplacement(int n) {
        int result = 0;
        while (n != 1){
            if ((n & 1) == 0) n = n >> 1;
            else {
                if ((n & 2) == 2) {
                    if (n == 3) {
                        result += 2;
                        return result;
                    }
                    n = n >> 1;
                    n++;
                    result++;
                } else
                    n--;
            }
            result++;
        }
        return result;
    }
}
