class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        if len(num) <= 2:
            return False
        self.check = False
        self.helper(num, 0, [])
        return self.check


    def helper(self, num, c, num_list):
        if num == "" and c > 2:
            self.check = True
        for i in range(len(num)):
            cur_num = num[:i+1]
            if (len(cur_num) >= 2 and cur_num[0] != "0") or len(cur_num) == 1:
                cur_num = int(cur_num)
                if len(num_list) < 2:
                    self.helper(num[i + 1:], c + 1, num_list + [cur_num])
                elif cur_num == (num_list[-1] + num_list[-2]):
                    self.helper(num[i + 1:], c + 1, num_list + [cur_num])

# Another Solution
class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        for i in range(len(num) - 2):
            for j in range(i + 1, len(num)):
                if self.helper(0, i, j, num):
                    return True
        return False

    def helper(self,i1,i2,i3,num):
        if num[i1] == "0" and i1 != i2:
            return False
        if num[i2 + 1] == "0" and i3 != i2 + 1:
            return False
        if i3 == len(num) - 1 and i1 != 0:
            return True
        for i in range(i3 + 1, len(num)):
            if int(num[i1 : i2 + 1]) + int(num[i2 + 1 : i3 + 1]) != int(num[i3 + 1 : i + 1]):
                continue
            if self.helper(i2 + 1, i3, i, num):
                return True
        return False
