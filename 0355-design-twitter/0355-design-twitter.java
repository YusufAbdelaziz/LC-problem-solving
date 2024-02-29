class Twitter {

  private class User {
    private int id;
    private Set<Integer> followees;
    private LinkedList<Tweet> tweets;

    public User(int id) {
      this.id = id;
      followees = new HashSet<>();
      tweets = new LinkedList<>();
      follow(id);
    }

    public void postTweet(int tweetId) {
      tweets.addFirst(new Tweet(tweetId, timestamp++));
    }

    public void follow(int followee) {
      if (!followees.contains(followee)) {
        followees.add(followee);
      }
    }

    public void unfollow(int followee) {
      if (followees.contains(followee)) {
        followees.remove(followee);
      }
    }
  }

  class Tweet {
    private int id;
    private int timestamp;

    public Tweet(int id, int timestamp) {
      this.id = id;
      this.timestamp = timestamp;
    }

    public int getId() {
      return id;
    }

    public int getTimestamp() {
      return timestamp;
    }

  }

  private static int timestamp = 0;
  private HashMap<Integer, User> users;

  public Twitter() {
    users = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    if (!users.containsKey(userId)) {
      users.put(userId, new User(userId));
    }

    var user = users.get(userId);

    user.postTweet(tweetId);
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    if (!users.containsKey(userId) || users.get(userId).followees.size() == 0)
      return res;
    PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.getTimestamp() - a.getTimestamp());
    var user = users.get(userId);

    for (Integer followeeId : user.followees) {
      pq.addAll(users.get(followeeId).tweets);
    }

    while(!pq.isEmpty()) {
        if(res.size() == 10) return res;
        res.add(pq.poll().id);
    }
      
    return res;
  }

  public void unfollow(int followerId, int followeeId) {
    if (users.containsKey(followerId)) {
      var user = users.get(followerId);
      user.unfollow(followeeId);

    }
  }

  public void follow(int followerId, int followeeId) {
    if (!users.containsKey(followerId)) {
      users.put(followerId, new User(followerId));
    }
    if (!users.containsKey(followeeId)) {
      users.put(followeeId, new User(followeeId));
    }

    User follower = users.get(followerId);

    follower.follow(followeeId);

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