package com.pluralsight.courseinfo.domian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void createCourseException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Course course = new Course("", "", 5, "", Optional.empty());
        });
    }

    @Test
    void rejectBlankNotes(){
        assertThrows(IllegalArgumentException.class, () -> {
            Course course = new Course("1", "title", 5, "url", Optional.of(""));
        });
    }

}