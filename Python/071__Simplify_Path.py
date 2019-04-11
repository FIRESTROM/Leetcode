class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stack = []
        path = path.split("/")
        for p in path:
            if len(p) == 0:
                continue

            if p == ".":
                continue
            elif p == "..":
                if len(stack) != 0:
                    stack.pop(-1)
            else:
                stack.append(p)
        return "/" + "/".join(stack)
        
