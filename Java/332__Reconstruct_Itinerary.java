class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0)
            return new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(String::compareTo));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        LinkedList<String> result = new LinkedList<>();
        helper("JFK", graph, result);
        return result;
    }

    private void helper(String start, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> queue = graph.get(start);
        while (queue != null && !queue.isEmpty()) {
            String adj = queue.poll();
            helper(adj, graph, result);
        }
        result.addFirst(start);
  }
}
