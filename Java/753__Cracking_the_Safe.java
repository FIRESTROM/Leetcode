class Solution {
    public String crackSafe(int n, int k) {
        int size = (int) Math.pow(k, n);  /* total num nodes inside graph */
        /* initialize password to be n digits of '0's */
        char[] password = new char[n];
        Arrays.fill(password, '0');
        StringBuilder result = new StringBuilder(String.valueOf(password));
        Set<String> visited = new HashSet<>();
        visited.add(result.toString());
        /* traverse each node exactly once to minimize the result  */
        if (dfs(result, visited, n, k, size))
            return result.toString();
        return "";
    }

    /*  A node in the graph is one possible combination of n digits
        where each digit is chosen from [0,k)
        e.g.    n = 2, k = 2,
                total combination = 4 (00, 01, 10, 11)
                n = 3, k = 6
                total combination = 6^3
                (each of the 3 digits has 6 possibilities, [0-5])
    */
    public boolean dfs(StringBuilder result, Set<String> visited, int n, int k, int size) {
        /* base case: all nodes are visited  */
        if (visited.size() == size) return true;

        /* reuse (n-1) digits from last node to form new node */
        String prefix = result.substring(result.length() - n + 1, result.length());

	   /* append one digit to prefix */
        for (char i = '0'; i < '0'+ k; i++) {
            String password = prefix + i;
            if (!visited.contains(password)) {
                result.append(i);
                visited.add(password);
                if (dfs(result, visited, n, k, size))
                    return true;
                visited.remove(password);  /* backtracking */
                result.deleteCharAt(result.length()-1);
            }
        }
        return false;
    }
}
