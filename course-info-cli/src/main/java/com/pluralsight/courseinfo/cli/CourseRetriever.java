package com.pluralsight.courseinfo.cli;

import com.pluralsight.courseinfo.cli.service.CourseRetrievalService;
import com.pluralsight.courseinfo.cli.service.CourseStorageService;
import com.pluralsight.courseinfo.cli.service.PluralsightCourse;
import com.pluralsight.courseinfo.repository.CourseRepository;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import java.util.List;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String[] args) {
        LOG.info("CourseRetriever starting!");
        if (args.length == 0){
            LOG.warn("Please provide an author name as first argument.");
            return;
        }

        try {
            int i = 0;
            while (i < args.length) {
                retrieveCourses(args[i]);
                i++;
            }
        } catch (Exception e){
            LOG.error("Unexpected error", e);
        }

    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
        CourseRetrievalService courseRetrievalService = new CourseRetrievalService();
        CourseRepository courseRepository = CourseRepository.openCourseRepository("./courses.db");
        CourseStorageService courseStorageService = new CourseStorageService(courseRepository);

        List<PluralsightCourse> coursesToStore = courseRetrievalService.getCoursesFor(authorId)
                .stream()
                .filter(course -> !course.isRetired())
                .toList();

        if (coursesToStore.isEmpty()) {
            LOG.info("This author has no courses on Pluralsight, or this author id does not exist.");
            return;
        }

        LOG.info("Retrieved the following {} courses {}", coursesToStore.size(), coursesToStore);
        courseStorageService.storePluralsightCourses(coursesToStore);
        LOG.info("Courses successfully stored");
    }
}
