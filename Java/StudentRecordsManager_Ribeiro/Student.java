package StudentRecordsManager_Ribeiro;

import java.util.Arrays;

/**
 * Class representing a student record with grades.
 * This class demonstrates basic OOP principles and data encapsulation.
 */
public class Student {
    // Add private fields for studentId, name, grades array, averageGrade, and letterGrade
    private String studentId, name;
    private int[] grades;
    private double averageGrade;
    private char letterGrade;
    
    /**
     * Constructor to initialize a Student object
     * @param studentId The student's ID
     * @param name The student's name
     * @param grades Array of the student's grades
     */
    public Student(String studentId, String name, int[] grades) {
        // Initialize fields and calculate average and letter grade
        this.studentId = studentId;
        this.name = name;
        this.grades = grades;
        this.averageGrade = calculateAverage();
        this.letterGrade = determineLetterGrade();
    }
    
    /**
     * Calculates the average of all grades
     * @return The average grade as a double
     */
    private double calculateAverage() {
        // Calculate and return the average of all grades
        double averageGrade = 0;

        for (int i : this.grades) {
            averageGrade += i;
        }

        return averageGrade / this.grades.length;
    }
    
    /**
     * Determines the letter grade based on the average
     * @return A character representing the letter grade (A, B, C, D, or F)
     */
    private char determineLetterGrade() {
        // Return letter grade based on the following scale:
        //       A: 90-100
        //       B: 80-89
        //       C: 70-79
        //       D: 60-69
        //       F: 0-59
        if (this.averageGrade >= 90) {
            return 'A';
        } else if (this.averageGrade >= 80) {
            return 'B';
        } else if (this.averageGrade >= 70) {
            return 'C';
        } else if (this.averageGrade >= 60) {
            return 'D';
        } else {
            return 'F'; // Placeholder return
        }
    }
    
    // Implement getters for all fields
    // Hint: Follow standard Java naming conventions for getters (getXxx method names)

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    /**
     * Returns a string representation of the student
     * @return String containing all student information
     */
    @Override
    public String toString() {
        // Return a string representation of the student including:
        //       - ID, name, all grades, average (formatted to 2 decimal places), and letter grade
        // Hint: Use StringBuilder to efficiently build the string as shown in the slides
        // Hint: Use String.format("%.2f", averageGrade) to format the average to 2 decimal places
        String studentId = "Student ID: " + this.studentId;
        String name = "Name: " + this.name;
        String grades = "Grades: " + Arrays.toString(this.grades);
        String averageGrade = "Average Grade: " + String.format("%.2f", this.averageGrade);
        String letterGrade = "Letter Grade: " + this.letterGrade;
        return studentId + "\n" + name + "\n" + grades + "\n" + averageGrade + "\n" + letterGrade;
    }
}