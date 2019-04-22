class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cur_str : cpdomains) {
            String[] cur_list = cur_str.split(" ");
            int count = Integer.parseInt(cur_list[0]);
            String[] cur_domain = cur_list[1].split("\\.");
            String temp = cur_domain[cur_domain.length - 1];
            map.put(temp, map.getOrDefault(temp, 0) + count);
            for (int i = cur_domain.length - 2; i >= 0; i--) {
                temp = cur_domain[i] + "." + temp;
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add("" + map.get(key) + " " + key);
        }
        return result;
    }
}
