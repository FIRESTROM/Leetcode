class TopVotedCandidate {

    class Vote {
        int person, time;
        Vote (int p, int t) {
            person = p;
            time = t;
        }
    }

    List<Vote> A;

    public TopVotedCandidate(int[] persons, int[] times) {
        A = new ArrayList();
        Map<Integer, Integer> count = new HashMap();
        int leader = -1;
        int leader_cnt = 0;

        for (int i = 0; i < persons.length; i++) {
            int cur_person = persons[i], cur_time = times[i];
            int cur_cnt = count.getOrDefault(cur_person, 0) + 1;
            count.put(cur_person, cur_cnt);

            if (cur_cnt >= leader_cnt) {
                if (cur_person != leader) {  // lead change
                    leader = cur_person;
                    A.add(new Vote(leader, cur_time));
                }

                if (cur_cnt > leader_cnt)
                    leader_cnt = cur_cnt;
            }
        }
    }

    public int q(int t) {
        int l = 1, r = A.size();
        while (l < r) {
            int mid =  (l + r) / 2;
            if (A.get(mid).time <= t)
                l = mid + 1;
            else
                r = mid;
        }

        return A.get(l - 1).person;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
