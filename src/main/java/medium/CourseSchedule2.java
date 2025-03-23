package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(3, arr)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesByCourse = toPrerequisitesByCourseMap(prerequisites);
        int[] orderOfCoursesToTake = new int[numCourses];
        AtomicInteger index = new AtomicInteger();
        Set<Integer> coursesBeingVisited = new HashSet<>();
        Set<Integer> coursesAlreadyVisited = new HashSet<>();
        for (int courseNumber = 0; courseNumber < numCourses; courseNumber++) {
            if (!dfs(courseNumber, prerequisitesByCourse, coursesAlreadyVisited, coursesBeingVisited,
                    orderOfCoursesToTake,
                    index)) {
                return new int[] {};
            }
        }
        return orderOfCoursesToTake;
    }

    private boolean dfs(int courseNumber, Map<Integer, Set<Integer>> prerequisitesByCourse,
                        Set<Integer> coursesAlreadyVisited, Set<Integer> coursesBeingVisited,
                        int[] orderOfCoursesToTake,
                        AtomicInteger index) {
        if (coursesAlreadyVisited.contains(courseNumber)) {
            return false;
        }

        if (coursesBeingVisited.contains(courseNumber)) {
            return true;
        }

        Set<Integer> prerequisites = prerequisitesByCourse.get(courseNumber);
        coursesAlreadyVisited.add(courseNumber);
        if (prerequisites != null) {
            for (Integer prerequisite : prerequisites) {
                if (!dfs(prerequisite, prerequisitesByCourse, coursesAlreadyVisited, coursesBeingVisited,
                        orderOfCoursesToTake, index)) {
                    return false;
                }
            }
        }
        coursesAlreadyVisited.remove(courseNumber);
        coursesBeingVisited.add(courseNumber);
        orderOfCoursesToTake[index.getAndIncrement()] = courseNumber;
        return true;
    }

    private Map<Integer, Set<Integer>> toPrerequisitesByCourseMap(int[][] prerequisites) {
        Map<Integer, Set<Integer>> courseToPrerequisites = new HashMap<>();
        for (int[] courseToPrerequisite : prerequisites) {
            int course = courseToPrerequisite[0];
            int prerequisite = courseToPrerequisite[1];
            Set<Integer> prerequisitesForCourse = courseToPrerequisites.get(course);
            if (prerequisitesForCourse != null) {
                prerequisitesForCourse.add(prerequisite);
            } else {
                Set<Integer> prereq = new HashSet<>();
                prereq.add(prerequisite);
                courseToPrerequisites.put(course, prereq);
            }
        }
        return courseToPrerequisites;
    }
}
