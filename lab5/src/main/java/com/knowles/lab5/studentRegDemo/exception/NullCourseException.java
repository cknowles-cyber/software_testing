package com.knowles.lab5.studentRegDemo.exception;

public class NullCourseException extends Exception {
    public NullCourseException() {
        super("No such course exists");
    }
}
