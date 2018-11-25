package SystemDesignCodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by hadoop on 7/10/17.
 */
public class MiniTwitter {
    public static int  friendshipId;
    public class Tweet{
        public int id;
        public int user_id;
        public String text;
        Tweet(int user_id,String text){
            this.user_id = user_id;
            this.text = text;
        }
    }
    public class FriendShip{
        public int id;
        public int from_user_id;
        public int to_user_id;
        public FriendShip(int id,int from_user_id,int to_user_id){
            this.id = id;
            this.from_user_id = from_user_id;
            this.to_user_id = to_user_id;
        }
    }
    public class  User{
        public  int id;
        public User(int id){
            this.id = id;
        }
    }
    // Tablessss in any database
    ArrayList<User> userTable;
    ArrayList<FriendShip> friendShipTable;
    ArrayList<Tweet> tweetTable;

    public MiniTwitter(){
        userTable = new ArrayList<>();
        friendShipTable = new ArrayList<>();
        tweetTable = new ArrayList<>();
    }

    public List<Tweet> getNewsFeed(int user_id) {
        //1 find all followings
        Set<Integer> followings = new HashSet<>();
        for (FriendShip friendShip : friendShipTable) {
            if (friendShip.from_user_id == user_id) {
                followings.add(friendShip.to_user_id);
            }
        }
        //go through tweet table
        List<Tweet> ret = new ArrayList<>();
        for (Tweet tweet : tweetTable) {
            if (followings.contains(tweet.user_id)) {
                ret.add(tweet);
                if (ret.size() == 10) {
                    return ret;
                }
            }
        }
        return ret;
    }

        public List<Tweet> getTimeLine(int user_id) {

            List<Tweet> ret = new ArrayList<>();
            for (Tweet t : tweetTable) {
                if (t.user_id == user_id) {
                    ret.add(t);
                    if (ret.size() == 10) {
                        return ret;
                    }
                }
            }
            return ret;
        }

        public void follow(int from_user_id,int to_user_id){
        friendShipTable.add(new FriendShip(friendshipId++,from_user_id,to_user_id));
        }

}
