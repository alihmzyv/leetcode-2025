package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(3, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesByCourse = toPrerequisitesByCourseMap(prerequisites);
        Set<Integer> visitedCourses = new HashSet<>();
        for (int courseNumber = 0; courseNumber < numCourses; courseNumber++) {
            if (!canFinish(courseNumber, prerequisitesByCourse, visitedCourses)) {
                return false;
            }
        }
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

    private boolean canFinish(int courseNumber, Map<Integer, Set<Integer>> prerequisitesByCourse, Set<Integer> visitedCourses) {
        if (visitedCourses.contains(courseNumber)) {
            return false;
        }
        Set<Integer> prerequisites = prerequisitesByCourse.get(courseNumber);
        if (prerequisites == null || prerequisites.isEmpty()) {
            return true;
        }
        visitedCourses.add(courseNumber);
        for (int prerequisite : prerequisites) {
            if (!canFinish(prerequisite, prerequisitesByCourse, visitedCourses)) {
                return false;
            }
        }
        visitedCourses.remove(courseNumber);
        prerequisitesByCourse.put(courseNumber, null);
        return true;
    }
}
