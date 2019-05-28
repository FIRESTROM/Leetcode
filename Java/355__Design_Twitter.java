class Twitter {

    int timeStamp;
    Map<Integer, List<Integer>> followMap;
    Map<Integer, List<Tweet>> postMap;
    PriorityQueue<Tweet> pq;

    class Tweet {
        int tweetId, timeStamp;
        public Tweet(int id, int time) {
            tweetId = id;
            timeStamp = time;
        }
    }

    /** comparator for PriorityQueue */
    private class postComparator implements Comparator<Tweet> {

        public int compare(Tweet tweet1, Tweet tweet2) {
            return tweet1.timeStamp - tweet2.timeStamp;
        }

        public boolean equals(Tweet tweet1, Tweet tweet2) {
            return tweet1.tweetId == tweet2.tweetId && tweet1.timeStamp == tweet2.timeStamp;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
        followMap = new HashMap<Integer, List<Integer>>();
        postMap = new HashMap<Integer, List<Tweet>>();
        pq = new PriorityQueue<Tweet>(1, new postComparator());
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!postMap.containsKey(userId))
            postMap.put(userId, new ArrayList<Tweet>());
        postMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();
        if (postMap.containsKey(userId)) {
            for (Tweet post : postMap.get(userId)) {
                pq.add(post);
                if (pq.size() > 10)
                    pq.poll();
            }
        }
        if (followMap.containsKey(userId)) {
            for (Integer followeeId : followMap.get(userId)) {
                if (!postMap.containsKey(followeeId) || followeeId == userId)
                    continue;
                for (Tweet post : postMap.get(followeeId)) {
                    pq.add(post);
                    if (pq.size() > 10)
                        pq.poll();
                }
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll().tweetId);
        }
        Collections.reverse(result);
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId))
            followMap.put(followerId, new ArrayList<Integer>());
        if (!followMap.get(followerId).contains(followeeId))
            followMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId))
            followMap.get(followerId).remove((Integer) followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
