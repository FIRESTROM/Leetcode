class Solution(object):
    def generatePalindromes(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        counter = collections.Counter(s)
        mid_char, front_half, result = "", "", []

        for char in counter:
            if counter[char] % 2 != 0:
                if mid_char:
                    return []
                else:
                    mid_char = char
            front_half += char * (counter[char] / 2)

        self.backTracking(front_half, 0, mid_char, result)
        return result

    def backTracking(self, front_half, start, mid_char, result):
        if start == len(front_half):
            result.append(front_half + mid_char + front_half[::-1])
            return
        for i in range(start, len(front_half)):
            if i > start and (front_half[i] == front_half[i-1] or front_half[i] == front_half[start]):
                continue
            if i == start:
                perm = front_half
            else:
                perm = front_half[:start] + front_half[i] + front_half[start + 1 : i] + front_half[start] + front_half[i + 1:]

            self.backTracking(perm, start + 1, mid_char, result)
