/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }
        Collections.sort(intervals, Comparator.comparing(e->e.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (end >= intervals.get(i).start) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}

// Faster way using stack
class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals,new Comparator<Interval>() {
            public int compare(Interval a,Interval b){return (a.start - b.start);}
        });
        Stack<Interval> result = new Stack<Interval>();
        if (intervals.size() == 0) {
          return result;
        }
        int end = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            if (!result.isEmpty() && intervals.get(i).start <= end) {
                Interval top = result.pop();
                end = Math.max(intervals.get(i).end, end);
                top.end = end;
                result.push(top);
            } else {
                result.push(intervals.get(i));
                end = intervals.get(i).end;
            }
        }
        return result;
    }
}
