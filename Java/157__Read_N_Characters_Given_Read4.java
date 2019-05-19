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
    public int read(char[] buf, int n) {
        int buf_idx = 0, cur_read;
        char[] load = new char[4];
        while (buf_idx < n) {
            cur_read = read4(load);
            for (int i = 0; i < cur_read && buf_idx < n; i++) {
                buf[buf_idx++] = load[i];
            }
            if (cur_read < 4)
                break;
        }
        return buf_idx;
    }
}
