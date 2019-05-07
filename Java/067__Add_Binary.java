class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, incre = 0;
        String result = "";
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (incre == 0) {
                    result = "0" + result;
                } else {
                    result = "1" + result;
                }
                incre = 1;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (incre == 0) {
                    result = "0" + result;
                } else {
                    result = "1" + result;
                }
                incre = 0;
            } else {
                if (incre == 0) {
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
            }
            i--;
            j--;
        }
        if (i < 0) {
            while (j >= 0) {
                if (b.charAt(j) == '0' && incre == 0) {
                    result = "0" + result;
                } else if ((b.charAt(j) == '0' && incre == 1) || (b.charAt(j) == '1' && incre == 0)) {
                    result = "1" + result;
                    incre = 0;
                } else {
                    result = "0" + result;
                    incre = 1;
                }
                j--;
            }
        } else {
            while (i >= 0) {
                if (a.charAt(i) == '0' && incre == 0) {
                    result = "0" + result;
                } else if ((a.charAt(i) == '0' && incre == 1) || (a.charAt(i) == '1' && incre == 0)) {
                    result = '1' + result;
                    incre = 0;
                } else {
                    result = "0" + result;
                    incre = 1;
                }
                i--;
            }
        }
        if (incre == 1) {
            result = "1" + result;
        }
        return result;
    }
}
