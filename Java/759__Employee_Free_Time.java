class Solution {

    class Interval {
        int start;
        int end;
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[][] employeeFreeTime(int[][][] schedule) {
        PriorityQueue<Deque<Interval>> pq = new PriorityQueue<>((x, y) -> {
            return x.peek().start - y.peek().start;
        });
        for (int[][] intervals : schedule) {
            Deque<Interval> queue = new ArrayDeque<>();
            for (int[] interval : intervals)
                queue.add(new Interval(interval[0], interval[1]));
            pq.add(queue);
        }
        List<Interval> result_lst = new ArrayList<>();
        Interval prev = new Interval(0, pq.peek().peek().start);

        while (pq.size() > 0) {
            Deque<Interval> temp = pq.remove();
            Interval next = temp.remove();
            if (temp.size() > 0)
                pq.add(temp);
            if (prev.end < next.start) {
                result_lst.add(new Interval(prev.end, next.start));
                prev = next;
            } else {
                prev.end = Math.max(prev.end, next.end);
            }
        }

        int[][] result = new int[result_lst.size()][2];
        for (int i = 0; i < result_lst.size(); i++) {
            result[i][0] = result_lst.get(i).start;
            result[i][1] = result_lst.get(i).end;
        }
        return result;

    }
}
