/*
 * @ (#) CourseList.java    1.0   Aug 26, 2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.  
 */
package iuh.fit.se;
/*
* @description:
* @author: Quoc Nguyen
* @date:  Aug 26, 2024
* @version:   1.0
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	     */
	    public boolean addCourse(Course course) {
	        // check if course is null
	        if (course == null)
	            return false;
	        // check if course already exists
	        if (exists(course)) // Check if id of course duplicate
	            return false;
	        // check if the array is full
	        if (count == courses.length)
	            return false;
	        // add course to the array
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
	     * Description: Remove a course from the list based on course ID
	     * @param id The ID of the course to be removed
	     * @return true if the course is removed successfully, false otherwise
	     */
	    public boolean removeCourse(String id) {
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(id)) {
	                // Shift courses left to fill the gap
	                for (int j = i; j < count - 1; j++) {
	                    courses[j] = courses[j + 1];
	                }
	                courses[count - 1] = null;
	                count--;
	                return true;
	            }
	        }
	        return false;
	    }

	    /**
	     * Description: Find a course by its ID
	     * @param id The ID of the course
	     * @return The course if found, null otherwise
	     */
	    public Course findCourseById(String id) {
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(id)) {
	                return courses[i];
	            }
	        }
	        return null;
	    }

	    /**
	     * Description: Find courses by their title (partial match)
	     * @param title The title to search for
	     * @return An array of courses that match the title
	     */
	    public Course[] findCoursesByTitle(String title) {
	        List<Course> result = new ArrayList<>();
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
	                result.add(courses[i]);
	            }
	        }
	        return result.isEmpty() ? null : result.toArray(new Course[0]);
	    }

	    /**
	     * Description: Find courses by department
	     * @param department The department to search for
	     * @return An array of courses that belong to the department
	     */
	    public Course[] findCoursesByDepartment(String department) {
	        List<Course> result = new ArrayList<>();
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getDepartment().equalsIgnoreCase(department)) {
	                result.add(courses[i]);
	            }
	        }
	        return result.isEmpty() ? null : result.toArray(new Course[0]);
	    }

	    /**
	     * Description: Sort courses by title
	     * @return A new array of courses sorted by title
	     */
	    public Course[] sortCoursesByTitle() {
	        Course[] sortedCourses = Arrays.copyOf(courses, count);
	        Arrays.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
	        return sortedCourses;
	    }

	    /**
	     * Description: Find courses with the maximum credits
	     * @return An array of courses with the maximum credits
	     */
	    public Course[] findCoursesWithMaxCredits() {
	        int maxCredits = Integer.MIN_VALUE;
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getCredit() > maxCredits) {
	                maxCredits = courses[i].getCredit();
	            }
	        }
	        List<Course> result = new ArrayList<>();
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null && courses[i].getCredit() == maxCredits) {
	                result.add(courses[i]);
	            }
	        }
	        return result.toArray(new Course[0]);
	    }

	    /**
	     * Description: Find the department with the most courses
	     * @return The department name with the most courses
	     */
	    public String findDepartmentWithMostCourses() {
	        // Create a map to count courses per department
	        java.util.Map<String, Integer> departmentCount = new java.util.HashMap<>();
	        for (int i = 0; i < count; i++) {
	            if (courses[i] != null) {
	                departmentCount.put(courses[i].getDepartment(), departmentCount.getOrDefault(courses[i].getDepartment(), 0) + 1);
	            }
	        }
	        // Find the department with the maximum courses
	        String maxDepartment = null;
	        int maxCount = 0;
	        for (java.util.Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
	            if (entry.getValue() > maxCount) {
	                maxCount = entry.getValue();
	                maxDepartment = entry.getKey();
	            }
	        }
	        return maxDepartment;
	    }

	    public Course[] getCourses() {
	        return Arrays.copyOf(courses, count);
	    }
	}