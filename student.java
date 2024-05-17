package com.example.studentpercentagecalculator;

public class student {  // creating class
    // class members
    private String fullName;
    private float obtainedMarks;
    private float totalMarks;
    private String percentage;
    // constructor
    public student(String fullName, float obtainedMarks, float totalMarks, String percentage) {
        this.fullName = fullName;  // objects and initialization
        this.obtainedMarks = obtainedMarks;
        this.totalMarks = totalMarks;
        this.percentage = percentage;
    }
    // getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public float getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(float totalMarks) {
        this.totalMarks = totalMarks;
    }

    public float getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(float obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}