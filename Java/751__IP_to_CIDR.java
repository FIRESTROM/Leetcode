class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> result = new ArrayList();
        while (n > 0) {
            int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)),
                                33 - bitLength(n));
            result.add(longToIP(start) + "/" + mask);
            start += 1 << (32 - mask);
            n -= 1 << (32 - mask);
        }
        return result;
    }

    private long ipToLong(String ip) {
        long result = 0;
        for (String x: ip.split("\\.")) {
            result = 256 * result + Integer.valueOf(x);
        }
        return result;
    }

    private String longToIP(long x) {
        return String.format("%s.%s.%s.%s",
            x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
    }

    private int bitLength(long x) {
        if (x == 0)
            return 1;
        int result = 0;
        while (x > 0) {
            x >>= 1;
            result++;
        }
        return result;
    }
}
