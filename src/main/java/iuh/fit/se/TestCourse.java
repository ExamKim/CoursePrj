/*
 * @ (#) .java       1.0 8/27/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package iuh.fit.se;

import java.util.Scanner;

/**
 * @description:
 * @author: Chiu Kim Thi
 * @version: 1.0
 * @created: 8/27/2024
 */

public class TestCourse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find course by ID");
            System.out.println("5. Find courses by title");
            System.out.println("6. Find courses by department");
            System.out.println("7. Sort courses by title");
            System.out.println("8. Find courses with max credits");
            System.out.println("9. Find department with most courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.print("Enter course id to remove: ");
                    String id = sc.nextLine();
                    if (courseList.removeCourseById(id)) {
                        System.out.println("Course removed successfully!");
                    } else {
                        System.out.println("Course not found!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter course id to find: ");
                    String id = sc.nextLine();
                    Course course = courseList.findCourseById(id);
                    if (course != null) {
                        System.out.println("Course found: " + course);
                    } else {
                        System.out.println("Course not found!");
                    }
                }
                case 5 -> {
                    System.out.print("Enter course title to search: ");
                    String title = sc.nextLine();
                    Course[] courses = courseList.findCoursesByTitle(title);
                    if (courses != null) {
                        System.out.println("Courses found:");
                        displayCourses(courses);
                    } else {
                        System.out.println("No courses found with the title containing '" + title + "'.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter department name to search: ");
                    String department = sc.nextLine();
                    Course[] courses = courseList.findCoursesByDepartment(department);
                    if (courses != null) {
                        System.out.println("Courses found in department " + department + ":");
                        displayCourses(courses);
                    } else {
                        System.out.println("No courses found in department '" + department + "'.");
                    }
                }
                case 7 -> {
                    Course[] sortedCourses = courseList.sortCoursesByTitle();
                    System.out.println("Courses sorted by title:");
                    displayCourses(sortedCourses);
                }
                case 8 -> {
                    Course[] maxCreditCourses = courseList.findCoursesWithMaxCredits();
                    System.out.println("Courses with max credits:");
                    displayCourses(maxCreditCourses);
                }
                case 9 -> {
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    System.out.println("Department with the most courses: " + departmentWithMostCourses);
                }
                default ->
                        System.out.println("Invalid choice!");
            }
        } while (choice != 0);

    }

    private static void displayCourses(Course[] courses) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
        System.out.println("-------------------------------------------------------------");
        for (Course c : courses) {
            if (c != null)
                System.out.println(c);
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");
//        Course course9 = new Course("FIT109", "Computer Vision", 3, "FIT");
//        Course course10 = new Course("FIT110", "Natural Language Processing", 3, "FIT");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }


}


