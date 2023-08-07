package com.pluralsight.courseinfo.domian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void createCourseException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Course course = new Course("", "", 5, "");
        });
    }

}