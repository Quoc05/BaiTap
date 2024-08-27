/*
 * @ (#) TestCourse.java    1.0   Aug 26, 2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.  
 */
package iuh.fit.se;

import java.util.List;
import java.util.Scanner;

/*
* @description:
* @author: Quoc Nguyen
* @date:  Aug 26, 2024
* @version:   1.0
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
	            System.out.println("4. Find a course by ID");
	            System.out.println("5. Find courses by title");
	            System.out.println("6. Find courses by department");
	            System.out.println("7. Sort courses by title");
	            System.out.println("8. Find courses with max credits");
	            System.out.println("9. Find department with most courses");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // Consume newline
	            switch (choice) {
	                case 1 -> addCourse(sc, courseList);
	                case 2 -> displayAllCourses(courseList);
	                case 3 -> removeCourse(sc, courseList);
	                case 4 -> findCourseById(sc, courseList);
	                case 5 -> findCoursesByTitle(sc, courseList);
	                case 6 -> findCoursesByDepartment(sc, courseList);
	                case 7 -> sortCoursesByTitle(courseList);
	                case 8 -> findCoursesWithMaxCredits(courseList);
	                case 9 -> findDepartmentWithMostCourses(courseList);
	                case 0 -> System.out.println("Exiting...");
	                default -> System.out.println("Invalid choice!");
	            }
	        } while (choice != 0);

	        sc.close(); // Close the Scanner to avoid resource leaks
	    }

	    private static void addCourse(Scanner sc, CourseList courseList) {
	        System.out.print("Enter course id: ");
	        String id = sc.nextLine();
	        System.out.print("Enter course title: ");
	        String title = sc.nextLine();
	        System.out.print("Enter course credit: ");
	        int credit = sc.nextInt();
	        sc.nextLine(); // Consume newline
	        System.out.print("Enter course department: ");
	        String department = sc.nextLine();
	        Course course = new Course(id, title, credit, department);
	        if (courseList.addCourse(course)) {
	            System.out.println("Course added successfully!");
	        } else {
	            System.out.println("Course not added!");
	        }
	    }

	    private static void displayAllCourses(CourseList courseList) {
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

	    private static void removeCourse(Scanner sc, CourseList courseList) {
	        System.out.print("Enter course id to remove: ");
	        String id = sc.nextLine();
	        if (courseList.removeCourse(id)) {
	            System.out.println("Course removed successfully!");
	        } else {
	            System.out.println("Course not found!");
	        }
	    }

	    private static void findCourseById(Scanner sc, CourseList courseList) {
	        System.out.print("Enter course id to search: ");
	        String id = sc.nextLine();
	        Course course = courseList.findCourseById(id);
	        if (course != null) {
	            System.out.println("Course found: " + course);
	        } else {
	            System.out.println("Course not found!");
	        }
	    }

	    private static void findCoursesByTitle(Scanner sc, CourseList courseList) {
	        System.out.print("Enter course title to search: ");
	        String title = sc.nextLine();
	        Course[] courses = courseList.findCoursesByTitle(title);
	        if (courses != null) {
	            displayCourseArray(courses);
	        } else {
	            System.out.println("No courses found with the given title!");
	        }
	    }

	    private static void findCoursesByDepartment(Scanner sc, CourseList courseList) {
	        System.out.print("Enter department to search: ");
	        String department = sc.nextLine();
	        Course[] courses = courseList.findCoursesByDepartment(department);
	        if (courses != null) {
	            displayCourseArray(courses);
	        } else {
	            System.out.println("No courses found in the given department!");
	        }
	    }

	    private static void sortCoursesByTitle(CourseList courseList) {
	        Course[] sortedCourses = courseList.sortCoursesByTitle();
	        displayCourseArray(sortedCourses);
	    }

	    private static void findCoursesWithMaxCredits(CourseList courseList) {
	        Course[] maxCreditCourses = courseList.findCoursesWithMaxCredits();
	        if (maxCreditCourses != null) {
	            displayCourseArray(maxCreditCourses);
	        } else {
	            System.out.println("No courses found!");
	        }
	    }

	    private static void findDepartmentWithMostCourses(CourseList courseList) {
	        String department = courseList.findDepartmentWithMostCourses();
	        if (department != null) {
	            System.out.println("Department with most courses: " + department);
	        } else {
	            System.out.println("No courses found!");
	        }
	    }

	    private static void displayCourseArray(Course[] courses) {
	        System.out.println("-------------------------------------------------------------");
	        System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
	        System.out.println("-------------------------------------------------------------");
	        for (Course course : courses) {
	            System.out.println(course);
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
	        Course course7 = new Course("FIT107", "Machine Learning", 4, "FIT");
	        Course course8 = new Course("FIT108", "Artificial Intelligence", 4, "FIT");

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