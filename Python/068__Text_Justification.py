class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        res, tmp = [], []
        i = sumlen = 0
        while i < len(words):
            if sumlen + len(words[i]) + len(tmp) <= maxWidth:
                tmp.append(words[i])
                sumlen += len(words[i])
                i += 1
            else:  #store into res and clear tmp and sumlen
                if len(tmp) == 1:
                    res.append(tmp[0] + " " * (maxWidth - len(tmp[0])))
                elif (maxWidth - sumlen) % (len(tmp) - 1) == 0:
                    space = (maxWidth - sumlen) / (len(tmp) - 1)
                    res.append((" " * space).join(tmp))
                else:
                    space = (maxWidth - sumlen) / (len(tmp) - 1)#left:(space+1)*l right:(space)*(r),r=
                    l = (maxWidth - sumlen) - (len(tmp) - 1) * space
                    r = space - l
                    res.append((" " * (space + 1)).join(tmp[:l + 1]) + (" " * space) + (" " * space).join(tmp[l + 1:]))
                tmp = []
                sumlen = 0
        laststr = " ".join(tmp) #left justified and no extra space.
        res.append(laststr + " " * (maxWidth - len(laststr)))
        return res
