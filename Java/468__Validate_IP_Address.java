class Solution {
    public String validIPAddress(String IP) {
        String[] IPv4 = IP.split("\\.", -1);
        String[] IPv6 = IP.split(":", -1);

        if (IPv4.length == 4) {
            for (String word : IPv4) {
                if (word.isEmpty()) return "Neither";
                if (word.length() > 1 && (word.charAt(0) == '0' || word.charAt(0) == '-')) return "Neither";
                try {
                    int decimal = Integer.parseInt(word);
                    if (decimal < 0 || decimal > 255) {
                        return "Neither";
                    }
                } catch (NumberFormatException nfe) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        if (IPv6.length == 8) {
            for (String word : IPv6) {
                if (word.length() > 4 || word.length() == 0) {
                    return "Neither";
                }
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!Character.isDigit(c) && "abcdefABCDEF".indexOf(c) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

}
