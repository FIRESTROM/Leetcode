class Solution {

    HashMap<Integer, String> map;
    HashMap<Integer, String> level;

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        build();
        String result = "";
        int remain = 0, index = 0;
        while (num != 0) {
            String temp = "";
            remain = num % 1000;
            num = num / 1000;
            if (remain == 0) {
                index++;
                continue;
            }
            if (remain >= 100) {
                temp = map.get(remain / 100) + " Hundred";
                remain = remain % 100;
                if (remain != 0) {
                    temp += " ";
                }
            }
            if (remain >= 20) {
                temp += map.get(remain - remain % 10);
                if (remain % 10 != 0) {
                    temp += " " + map.get(remain % 10);
                }
            } else {
                temp += map.get(remain);
            }
            if (index != 0) {
                temp += " " + level.get(index);
            }
            if (result == "") {
                result = temp;
            } else {
                result = temp + " " + result;
            }
            index++;
        }
        return result;
    }

    private void build() {
        map = new HashMap<>();
        map.put(0, "");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        level = new HashMap<>();
        level.put(0, "");
        level.put(1, "Thousand");
        level.put(2, "Million");
        level.put(3, "Billion");
    }

}
