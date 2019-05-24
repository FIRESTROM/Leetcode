class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                char oper = input.charAt(i);
                for (int a : diffWaysToCompute(input.substring(0, i)))
                    for (int b : diffWaysToCompute(input.substring(i + 1)))
                        result.add(oper == '+' ? a + b : (oper == '-' ? a - b : a * b));
            }
        }
        if (result.isEmpty())
            result.add(Integer.parseInt(input));
        map.put(input, result);
        return result;
    }

}
