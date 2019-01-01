class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        def dfs(i, S = []):
            if i > len(s):
                return
            elif i == len(s):
                if len(S) == 4:
                    result.append(S)
                return
            else:
                if len(S) >= 4:
                    return
                else:
                    dfs(i + 1, S + [s[i]])
                    if s[i : i + 2] >= "10":
                        dfs(i + 2, S + [s[i : i + 2]])
                    if s[i : i + 3] >= "100" and s[i : i + 3] <= "255":
                        dfs(i + 3, S + [s[i : i + 3]])
        dfs(0)
        result = [".".join(add) for add in result]
        return result
