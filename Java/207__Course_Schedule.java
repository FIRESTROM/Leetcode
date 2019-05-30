class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return !hasCycle(graph, numCourses);

    }

    private boolean hasCycle(List<Integer>[] graph, int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, graph, visited, onStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(int v, List<Integer>[] graph, boolean[] visited, boolean[] onStack) {
        visited[v] = true;
        onStack[v] = true;
        boolean hasCycle = false;
        for (int w : graph[v]) {
            if (!visited[w]) {
                hasCycle = hasCycle(w, graph, visited, onStack);
                if (hasCycle) {
                    break;
                }
            } else if (onStack[w]) {
                hasCycle = true;
                break;
            }
        }
        onStack[v] = false;
        return hasCycle;
    }
}
