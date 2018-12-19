class Solution:
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        for i in range(1, n+1):
            if (i % 15 == 0) :
                result += ["FizzBuzz"]
                continue;
            if (i % 5 == 0) :
                result += ["Buzz"]
                continue;
            if (i % 3 == 0) :
                result += ["Fizz"]
                continue;
            result += [str(i)]
        return result

        
