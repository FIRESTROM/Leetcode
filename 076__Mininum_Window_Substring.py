class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(t) > len(s):
            return ""
        self.t = t
        count_s = {}
        self.count_t = {}
        for char in t:
            if char in self.count_t:
                self.count_t[char] += 1
            else:
                self.count_t[char] = 1
                count_s[char] = 0
        for char in s:
            if char in self.count_t:
                count_s[char] += 1

        if any(count_s[x] < self.count_t[x] for x in count_s.keys()):
            return ""

        def reduce(s, count_s):
            while s[0] not in t:
                s = s[1:]
            while s[-1] not in t:
                s = s[:len(s) - 1]

            if count_s[s[0]] == self.count_t[s[0]] and count_s[s[-1]] == self.count_t[s[-1]]:
                return s
            elif count_s[s[0]] == self.count_t[s[0]]:
                count_s[s[-1]] -= 1
                s = s[:len(s) - 1]
                return reduce(s, count_s)
            elif count_s[s[-1]] == self.count_t[s[-1]]:
                count_s[s[0]] -= 1
                s = s[1:]
                return reduce(s, count_s)
            else:
                count_s1 = dict(count_s)
                count_s1[s[-1]] -= 1
                s1 = s[:len(s) - 1]

                count_s[s[0]] -= 1
                s = s[1:]
                str_1 = reduce(s, count_s)
                str_2 = reduce(s1, count_s1)

                if len(str_1) < len(str_2):
                    return str_1
                return str_2

        return reduce(s, count_s)

        def minWindow(self, s, t):
                need, missing = Counter(t), len(t)
                i = I = J = 0
                for j, c in enumerate(s, 1):
                    missing -= need[c] > 0
                    need[c] -= 1
                    if not missing:
                        while need[s[i]] < 0: need[s[i]] += 1; i += 1
                        if not J or j - i <= J - I: I, J = i, j
                        need[s[i]] += 1; i += 1; missing += 1       # SPEEEEEEEED UP!
                return s[I : J]
