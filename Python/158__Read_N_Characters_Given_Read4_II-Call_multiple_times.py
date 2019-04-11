# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):

class Solution(object):

    def __init__(self):
        self.buf4 = [None] * 4
        self.buf4len = 0

    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        i = 0
        while i < n:
            if not self.buf4len:
                self.buf4len = read4(self.buf4)
                if not self.buf4len:
                    break
            cur_size = min(n - i, self.buf4len)
            buf[i:] = self.buf4[:cur_size]
            i += cur_size
            self.buf4[:self.buf4len - cur_size] = self.buf4[cur_size : self.buf4len]
            self.buf4len = self.buf4len - cur_size

        return i
