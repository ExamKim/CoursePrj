/*
 * @ (#) .java       1.0 8/27/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit.se;

/**
 * @description: This class represents a list of courses
 * @author: Chiu Kim Thi
 * @version: 1.0
 * @created: 8/27/2024
 */

public class CourseList {

    private Course[] courses;
    private static int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     */

    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // create an array of n elements
    }

    /**
     * Description: Add a course to the list
     * @param course
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     */
    public boolean addCourse(Course course) {
        //  check if course is null
        if(course == null)
            return false;
        //  check if course already exists
        if(exists(course)) //Check if id of course duplicate
            return false;
        //  check if the array is full
        if (count == courses.length)
            return false;
        //  add course to the array
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @param course The course to check
     * @return true if the course exists, false otherwise
     */
    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }
    /**
     * Description: Remove a course from the list by its ID
     * @param courseId The ID of the course to be removed
     * @return true if the course is removed successfully, false otherwise
     */
    public boolean removeCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(courseId)) {
                courses[i] = courses[count - 1]; // Replace the course with the last course in the array
                courses[count - 1] = null; // Set the last course to null
                count--; // Decrease the course count
                return true;
            }
        }
        System.out.println("Course with ID " + courseId + " does not exist.");
        return false;
    }

    /**
     * Description: Find a course by its ID
     * @param courseId The ID of the course to be found
     * @return the course if found, null otherwise
     */
    public Course findCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(courseId)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Description: Find courses by their title (partial match)
     * @param title The title of the courses to be found
     * @return an array of courses that match the title, or null if no courses are found
     */
    public Course[] findCoursesByTitle(String title) {
        Course[] matchedCourses = new Course[count];
        int matchedCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchedCourses[matchedCount++] = courses[i];
            }
        }
        return (matchedCount == 0) ? null : trimArray(matchedCourses, matchedCount);
    }

    /**
     * Description: Find courses by their department
     * @param department The department responsible for the courses
     * @return an array of courses in the specified department, or null if no courses are found
     */
    public Course[] findCoursesByDepartment(String department) {
        Course[] matchedCourses = new Course[count];
        int matchedCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getDepartment().equalsIgnoreCase(department)) {
                matchedCourses[matchedCount++] = courses[i];
            }
        }
        return (matchedCount == 0) ? null : trimArray(matchedCourses, matchedCount);
    }

    /**
     * Description: Sort the courses by their title
     * @return an array of sorted courses by title
     */
    public Course[] sortCoursesByTitle() {
        Course[] sortedCourses = new Course[count];
        System.arraycopy(courses, 0, sortedCourses, 0, count);
        java.util.Arrays.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
        return sortedCourses;
    }

    /**
     * Description: Find courses with the highest credit
     * @return an array of courses with the highest credit
     */
    public Course[] findCoursesWithMaxCredits() {
        if (count == 0) return null;
        int maxCredit = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }
        Course[] matchedCourses = new Course[count];
        int matchedCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getCredit() == maxCredit) {
                matchedCourses[matchedCount++] = courses[i];
            }
        }
        return trimArray(matchedCourses, matchedCount);
    }

    /**
     * Description: Find the department with the most courses
     * @return the name of the department with the most courses
     */
    public String findDepartmentWithMostCourses() {
        java.util.Map<String, Integer> departmentCounts = new java.util.HashMap<>();
        for (int i = 0; i < count; i++) {
            String dept = courses[i].getDepartment();
            departmentCounts.put(dept, departmentCounts.getOrDefault(dept, 0) + 1);
        }
        return departmentCounts.entrySet().stream().max(java.util.Map.Entry.comparingByValue()).get().getKey();
    }

    /**
     * Description: Helper method to trim an array to the specified length
     * @param array The array to be trimmed
     * @param length The new length of the array
     * @return a new array with the specified length
     */
    private Course[] trimArray(Course[] array, int length) {
        Course[] trimmedArray = new Course[length];
        System.arraycopy(array, 0, trimmedArray, 0, length);
        return trimmedArray;
    }

    public Course[] getCourses() {
        return courses;
    }
}


