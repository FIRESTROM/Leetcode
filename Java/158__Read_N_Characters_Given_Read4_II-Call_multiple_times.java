/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int buf4_idx = 0;
    private int currentLengh = 0;
    private char[] buf4;

    public int read(char[] buf, int n) {

        if (buf4 == null) {
            buf4 = new char[4];
            buf4_idx = 0;
            currentLengh = read4(buf4);
        }
        int cur_idx = 0;

        while (cur_idx < n) {
            for (; buf4_idx < Math.min(currentLengh, n - cur_idx + buf4_idx); cur_idx++, buf4_idx++) {
                buf[cur_idx] = buf4[buf4_idx];
            }
            if (cur_idx == n) {
                return n;
            }
            if (currentLengh < 4) {
                return cur_idx;
            }
            currentLengh = read4(buf4);
            buf4_idx = 0;
        }
        return cur_idx;

    }
}
