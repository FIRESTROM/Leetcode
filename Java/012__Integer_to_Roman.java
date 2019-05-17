class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num >= 5) {
            if (num >= 1000) {
                sb.append("M");
                num = num - 1000;
                continue;
            } else if (num >= 500) {
                if (num >= 900) {
                    sb.append("CM");
                    num = num - 900;
                    continue;
                } else {
                    sb.append("D");
                    num = num - 500;
                    continue;
                }
            } else if (num >= 100) {
                if (num >= 400) {
                    sb.append("CD");
                    num = num - 400;
                    continue;
                } else {
                    sb.append("C");
                    num = num - 100;
                    continue;
                }
            } else if (num >= 50) {
                if (num >= 90) {
                    sb.append("XC");
                    num = num - 90;
                    continue;
                } else {
                    sb.append("L");
                    num = num - 50;
                    continue;
                }
            } else if (num >= 10) {
                if (num >= 40) {
                    sb.append("XL");
                    num = num - 40;
                    continue;
                } else {
                    sb.append("X");
                    num = num - 10;
                    continue;
                }
            } else if (num >= 5) {
                if (num >= 9) {
                    sb.append("IX");
                    num = num - 9;
                    continue;
                } else {
                    sb.append("V");
                    num = num - 5;
                    continue;
                }
            }
        }

        if (num == 0)
            return sb.toString();
        if (num == 4) {
            sb.append("IV");
            return sb.toString();
        } else {
            while (num != 0) {
                sb.append("I");
                num--;
            }
            return sb.toString();
        }
    }
}
