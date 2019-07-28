Build the Subsequences

    public List<String> subsequences(String str) {
        Map<Integer, Set<String>> map = new HashMap<>();
        int len = str.size();
        int limit = Math.pow(2, len);
        for (int i = 1; i < limit; i++) {
          string cur = helper(str, i, len);
          if (!map.containsKey(cur.length())) map.put(cur.length(), new HashSet<String>);
          Set<String> cur_set = map.get(cur.length());
          cur_set.add(cur);
          map.put(cur.length(), cur_set);
        }
        List<String> result = new ArrayList<>();
        for (Set<String> cur_set : map.values())
          for (String str : cur_set)
            result.add(str);
        return result;
    }

    private String helper(String str, int binary, int len) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < len; i++) {
            if (binary & (1 << i))
                sb.append(str.charAt(i));
      return sb.toString();
    }



Consecutive Numbers Sum (Leetcode 829)

    class Solution {
        public int consecutiveNumbersSum(int N) {
            // 2N = k(2x + k + 1)
            int result = 0;
            for (int k = 1; k <= 2*N; ++k)
                if (2 * N % k == 0) {
                    int y = 2 * N / k - k - 1;
                    if (y % 2 == 0 && y >= 0)
                        result++;
                }
            return result;
        }
    }
    class Solution {
        public int consecutiveNumbersSum(int N) {
            while ((N & 1) == 0) N >>= 1;
            int ans = 1, d = 3;

            while (d * d <= N) {
                int e = 0;
                while (N % d == 0) {
                    N /= d;
                    e++;
                }
                ans *= e + 1;
                d += 2;
            }

            if (N > 1) ans <<= 1;
            return ans;
        }
    }


Intellengent String

public int max_substring_length(String alphabet, String charValue, String str, int k) {
  boolean[] isnormal = new boolean[26];
  int i = 0;
  for (char c : charValue.toCharArray()) isnormal[i++] = c == '0';
  char[] str_arr = str.toCharArray();
  int l = 0, r;
  int count = isnormal[str_arr[0] - 'a'] ? 1 : 0;
  int result = 0;
  for (int r = 0; r < str_arr.length; r++) {
    if (isnormal[str_arr[r] - 'a']) count++;
    while (count > k) {
      if (isnormal[str_arr[l] - 'a') count--;
      l++;
    }
    result = Math.max(result, r - l + 1);
  }
  return result;
}

Counting Bits

public List<Integer> counting_bits(int val) {
  String binary_val = Integer.toBinaryString(val);
  char[] char_arr = binary_val.toCharArray();
  int i = 0, count = 0;
  List<Integer> result = new LinkedList<>();
  for (char c : char_arr) {
    if (c == '1') {
      result.add(i);
      count++;
    }
    i++;
  }
  result.add(0, count);
  return result;
}

Even Subarray

public int distinctSubarraysAtMostKOdd(int[] nums, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < nums.length; i++) {
            int oddCount = 0;
            sb.setLength(0);

            for(int j = i; j < nums.length; j++) {
                if(isOdd(nums[j])) {
                    oddCount++;
                }

                if(oddCount > k)
                    break;

                sb.append("{").append(nums[j]).append("},");
                set.add(sb.toString());
            }
        }

        return set.size();
    }

private boolean isOdd(int x) {
    return (x & 1) == 1;
}


Climbing Hills

public int climbing_hill(int[] heights) {
  int[] sort_heights = new int[heights.length];
  for (int i = 0; i < heights.length; i++) sort_heights[i] = heights[i];
  Arrays.sort(sort_heights);
  int[] dp = new int[heights.length];
  dp[0] = Math.abs(heights[0] - sort_heights[0]);
  for (int i = 1; i < heights.length; i++) dp[i] = Math.min(Math.abs(heights[i] - sort_heights[i]), dp[i - 1]);
  for (int i = 1; i < heights.length; i++) {
		for (int j = 0; j < heights.length; j++) {
			if (j == 0) {
				dp[j] = abs(a[i]-b[1]))+(ll)(dp[1]);
			}else{
				dp[j]=((ll)MIN(dp[j-1],(ll)(dp[j])+(ll)(abs(a[i]-b[j]))));
			}
		}
	}
}
