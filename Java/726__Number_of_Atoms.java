class Solution {
    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap());
        for (int i = 0; i < N;) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> prev = stack.pop();
                int val_start = ++i, multi = 1;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                if (i > val_start) multi = Integer.parseInt(formula.substring(val_start, i));
                for (String s : prev.keySet()) {
                    int val = prev.get(s);
                    stack.peek().put(s, stack.peek().getOrDefault(s, 0) + val * multi);
                }
            } else {
                int char_start = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(char_start, i);
                int val_start = i;
                while (i < N && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i > val_start ? Integer.parseInt(formula.substring(val_start, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            result.append(name);
            int multiplicity = stack.peek().get(name);
            if (multiplicity > 1)
                result.append("" + multiplicity);
        }
        return new String(result);
    }
}
