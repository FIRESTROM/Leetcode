class Solution {

    private static final List<String> NUM = new ArrayList<String>();

    public List<String> basicCalculatorIV(String exp, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        Stack<Map<List<String>, Integer>> valStk = new Stack<>();
        Stack<Character> opStk = new Stack<>();

        Map<Character, Integer> opPriority = new HashMap<>();
        opPriority.put('+', 0);
        opPriority.put('-', 0);
        opPriority.put('*', 1);
        int i = 0, len = exp.length();
        while (i < len) {
            char c = exp.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (opPriority.containsKey(c)) {
                while (!opStk.isEmpty() && opStk.peek() != '(' && opPriority.get(opStk.peek()) >= opPriority.get(c)) {
                    Map<List<String>, Integer> right = valStk.pop(), left = valStk.pop();
                    valStk.push(calculate(opStk.pop(), left, right));
                }
                opStk.push(c);i++;
            } else if (c == '(') {
                opStk.push(c);i++;
            } else if (c == ')') {
                while (!opStk.isEmpty() && opStk.peek() != '(') {
                    Map<List<String>, Integer> right = valStk.pop(), left = valStk.pop();
                    valStk.push(calculate(opStk.pop(), left, right));
                }
                if (!opStk.isEmpty()) {
                    opStk.pop(); // '('
                }
                i++;
            } else if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < len && Character.isLetter(exp.charAt(i))) {
                    sb.append(exp.charAt(i++));
                }
                Map<List<String>, Integer> val = new HashMap<>();
                if (map.containsKey(sb.toString())) {
                    val.put(NUM, map.get(sb.toString()));
                } else {
                    List<String> vars = new ArrayList<>();
                    vars.add(sb.toString());
                    val.put(vars, 1);
                }
                valStk.push(val);
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < len && Character.isDigit(exp.charAt(i))) {
                    sb.append(exp.charAt(i++));
                }
                Map<List<String>, Integer> val = new HashMap<>();
                val.put(NUM, Integer.valueOf(sb.toString()));
                valStk.push(val);
            }
        }
        while (!opStk.isEmpty()) {
            Map<List<String>, Integer> right = valStk.pop(), left= valStk.pop();
            valStk.push(calculate(opStk.pop(), left, right));
        }
        return toList(valStk.pop());
    }


    Map<List<String>, Integer> calculate(char op, Map<List<String>, Integer> left, Map<List<String>, Integer> right) {
        if (op == '+' || op == '-') {
            for (Map.Entry<List<String>, Integer> e : right.entrySet()) {
                List<String> rkey = e.getKey();
                int rvalue = e.getValue();
                int lvalue = left.getOrDefault(rkey, 0);
                left.put(rkey, op == '+' ? lvalue + rvalue : lvalue - rvalue);
            }
            return left;
        } else {
            Map<List<String>, Integer> result = new HashMap<>();
            for (Map.Entry<List<String>, Integer> l_temp : left.entrySet()) {
                List<String> left_key = l_temp.getKey();
                int left_value = l_temp.getValue();
                for (Map.Entry<List<String>, Integer> r_temp : right.entrySet()) {
                    List<String> right_key = r_temp.getKey();
                    int right_value = r_temp.getValue();
                    List<String> multi_key = multiStr(left_key, right_key);
                    result.put(multi_key, result.getOrDefault(multi_key, 0) + left_value * right_value);
                }
            }
            return result;
        }
    }
    List<String> multiStr(List<String> left_key, List<String> right_key) {
        if (lkey.equals(NUM)) return right_key;
        if (rkey.equals(NUM)) return left_key;
        List<String> result = new ArrayList<>();
        int l = 0, r = 0, left_size = left_key.size(), right_size = right_key.size();
        while (l < left_size && r < right_size) {
            if (left_key.get(l).compareTo(right_key.get(r)) < 0) {
                result.add(left_key.get(l++));
            } else {
                result.add(right_key.get(r++));
            }
        }
        while (l < left_size) {
            result.add(left_key.get(l++));
        }
        while (r < right_size) {
            result.add(right_key.get(r++));
        }
        return result;
    }


    List<String> toList(Map<List<String>, Integer> map) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> key : map.keySet()) {
            if(!key.equals(NUM) && map.get(key) != 0) {
                result.add(key);
            }
        }
        Collections.sort(result, new Comparator<List<String>>() {
            public int compare(List<String> s1, List<String> s2) {
                int size1 = s1.size(), size2 = s2.size();
                if (size1 == size2) {
                    for (int i = 0; i < s1.size(); i++) {
                        if (!s1.get(i).equals(s2.get(i))) {
                            return s1.get(i).compareTo(s2.get(i));
                        }
                    }
                    return 0;
                }
                return size2 - size1;
            }
        });
        List<String> strResult = new ArrayList<>();
        int size = result.size();
        for (int i = 0; i < size; i++) {
            int factor = map.get(result.get(i));
            StringBuilder sb = new StringBuilder();
            for (String s : result.get(i)) {
                sb.append(s).append("*");
            }
            sb.deleteCharAt(sb.length() - 1);
            strResult.add(factor + "*" + sb.toString());
        }
        if (map.containsKey(NUM) && map.get(NUM) != 0) {
            strResult.add(String.valueOf(map.get(NUM)));
        }
        return strResult;
    }

}
