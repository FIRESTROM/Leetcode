class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        flipped = set()
        dic = {}
        def turn(cur_s, cur_player):
            ifWin = False
            key = cur_s + str(cur_player)
            if key in dic:
                return dic[key]
            for i in range(len(cur_s) - 1):
                if (cur_s[i : i + 2] == "++") and (i, i + 1) not in flipped:
                    flipped.add((i,i+1))
                    ifWin = turn(cur_s[:i] + "--" + cur_s[i + 2:], not cur_player)
                    flipped.remove((i, i + 1))
                    if not ifWin and cur_player:
                        return False
                    if ifWin and not cur_player:
                        dic[key] = True
                        return True
            if cur_player:
                return True
            else:
                return False

        return turn(s, False)

# DFS Solution
class Solution:
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        choices = {i for i in range(1, len(s)) if s[i] == s[i - 1] == "+"}
        def dfs(arr, moves, turn):
            if not moves:
                return turn == 1
            elif turn:
                return all(dfs(arr + [m], moves - {m - 1, m, m + 1}, 1 - turn) for m in moves) 
            else:
                return any(dfs(arr + [m], moves - {m - 1, m, m + 1}, 1 - turn) for m in moves)
        return not dfs([], choices, 1)
