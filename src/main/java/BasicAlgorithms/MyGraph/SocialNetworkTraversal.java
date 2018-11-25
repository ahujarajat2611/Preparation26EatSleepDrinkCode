package BasicAlgorithms.MyGraph;

import java.util.*;

/**
 * @author Baofeng Xue at 2016/5/13 18:18.
 *         Suppose you are an engineer on the Amazon Student team.Your team want to launch new feature called "Courses your social network have attended",
 *         that lists all the courses your social network are taking, sorted by popularity.
 *         A social network is defined as all direct friends and all direct friends of direct friends.
 *         People 3 level deep are not part of the social circle.
 *         <p>
 *         The recommendation logic is based on the following rules:
 *         <p>
 *         1. A user should only be recommended a course that their social network have attended but they have not attended.
 *         <p>
 *         2. The recommendation priority is driven by how many people have attended the same course -
 *         if multiple people attended the same course it should be higher in the recommendations than a course that only one person attended.
 **/
public class SocialNetworkTraversal {

    private Map<String, Integer> coursesMap = new HashMap<>();

    public List<String> getDirectFriendsForUser(String user) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Sue");
        strings.add("Amy");
        return strings;
    }

    public List<String> getAttendedCoursesForUser(String user) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        return strings;
    }

    public List<String> getRankedCourses(String user) {
        List<String> directFriendsForUser = getDirectFriendsForUser(user);
        for (String friend : directFriendsForUser) {
            List<String> coursesForUser = getAttendedCoursesForUser(friend);
            for (String course : coursesForUser) {
                if (coursesMap.get(course) == null) {
                    coursesMap.put(course, 1);
                } else {
                    coursesMap.put(course, coursesMap.get(course) + 1);
                }
            }
        }

        List<String> recommendation = new ArrayList<>();
        List<String> attendedCoursesForUser = getAttendedCoursesForUser(user);
        for (String course : coursesMap.keySet()) {
            if (!attendedCoursesForUser.contains(course)) {
                recommendation.add(course);
            }
        }

        Collections.sort(recommendation, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return coursesMap.get(o2) - coursesMap.get(o1);
            }
        });

        return recommendation;
    }
}