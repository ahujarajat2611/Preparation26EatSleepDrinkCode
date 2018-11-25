package SystemDesignCodes;


import java.util.*;

/**
 * Created by hadoop on 7/10/17.
 */
public class FriendShipService {
    HashMap<Integer,Set<Integer>> followers,followings;

    FriendShipService(){
        followers = new HashMap<>();
        followings = new HashMap<>();
    }
    public List<Integer> getFollowers(int userId){
        if(followers.containsKey(userId)){
            return new ArrayList<>(followers.get(userId));
        }
        return new ArrayList<>();
    }

    public List<Integer> getFollowings(int userId){
        if(followers.containsKey(userId)){
            return new ArrayList<>(followings.get(userId));
        }
        return new ArrayList<>();
    }
    public void follow(int from_user_id,int to_user_id){
        if(!followers.containsKey(from_user_id)){
            TreeSet treeSet = new TreeSet();
            followers.put(from_user_id,treeSet);
        }
        followers.get(from_user_id).add(to_user_id);

        if(!followings.containsKey(to_user_id)){
            TreeSet treeSet = new TreeSet();
            followings.put(to_user_id,treeSet);
        }
        followings.get(to_user_id).add(from_user_id);
    }
}
