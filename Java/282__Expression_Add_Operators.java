class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void helper(List<String> result, String cur_str, String num, int target, int start_idx, long eval, long multed) {
        if (start_idx == num.length()) {
            if (target == eval)
                result.add(cur_str);
            return;
        }
        for (int i = start_idx; i < num.length(); i++) {
            if (i != start_idx && num.charAt(start_idx) == '0')
                break;
            long cur_val = Long.parseLong(num.substring(start_idx, i + 1));
            if (start_idx == 0) {
                helper(result, cur_str + cur_val, num, target, i + 1, cur_val, cur_val);
            } else {
                helper(result, cur_str + "+" + cur_val, num, target, i + 1, eval + cur_val , cur_val);
                helper(result, cur_str + "-" + cur_val, num, target, i + 1, eval - cur_val, -cur_val);
                helper(result, cur_str + "*" + cur_val, num, target, i + 1, eval - multed + multed * cur_val, multed * cur_val );
            }
        }
    }
}
