/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty())  return new NestedInteger();
        if (s.charAt(0) != '[')  return new NestedInteger(Integer.valueOf(s));
        NestedInteger result = new NestedInteger();
        int start = 1;
        int count = 0;
        for (int end = 1; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (count == 0 && (ch == ']' || ch == ',')) {
                if (!s.substring(start, end).isEmpty()) {
                    result.add(deserialize(s.substring(start, end)));
                    start = end + 1;
                }
            }
            if (ch == '[')  count++;
            else if (ch == ']')  count--;
        }
        return result;
    }
}
