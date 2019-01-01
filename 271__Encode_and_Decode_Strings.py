class Codec:

    def encode(self, strs):
        """Encodes a list of strings to a single string.

        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""
        result = ""
        istr = "_"
        for s in strs:
            istr += str(len(result)) + "."
            result += s
        istr = istr[:len(istr) - 1]
        result += istr
        return result


    def decode(self, s):
        """Decodes a single string to a list of strings.

        :type s: str
        :rtype: List[str]
        """
        if s == "":
            return []
        ind = 0
        for i in range(len(s) - 1, -1, -1):
            if s[i] == "_":
                ind = i
                break

        istr = s[ind:]
        estr = s[:ind]

        inds = istr.lstrip("_").split(".")
        dstr = []
        prev = 0
        for i in range(len(inds)):
            start_ind = int(inds[i])
            if i == len(inds) - 1:
                end_ind = len(estr)
            else: end_ind = int(inds[i + 1])
            t = estr[start_ind : end_ind]
            dstr.append(t)
        return dstr

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))
