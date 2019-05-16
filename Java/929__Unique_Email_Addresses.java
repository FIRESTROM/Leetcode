class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> seen = new HashSet<>();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replace(".", "");
            seen.add(local + "@" + rest);
        }

        return seen.size();
    }
}
