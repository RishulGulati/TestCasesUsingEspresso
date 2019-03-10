package com.example.testcasesusingespresso.model;

import java.io.Serializable;

public class Courses implements Serializable {

    String courseShortName;
    String courseLongName;
    int courseImage;

    public Courses(String courseShortName, String courseLongNamel, int courseImage) {
        this.courseShortName = courseShortName;
        this.courseLongName = courseLongNamel;
        this.courseImage = courseImage;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public void setCourseShortName(String courseShortName) {
        this.courseShortName = courseShortName;
    }

    public String getCourseLongName() {
        return courseLongName;
    }

    public void setCourseLongName(String courseLongName) {
        this.courseLongName = courseLongName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseShortName='" + courseShortName + '\'' +
                ", courseLongNamel='" + courseLongName + '\'' +
                ", courseImage=" + courseImage +
                '}';
    }
}

