package com.pluralsight.courseinfo.cli;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);
    public static void main(String[] args) {
        LOG.info("CourseRetriever starting!");
        if (args.length == 0){
            LOG.warn("Please provide an author name as first argument.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch (Exception e){
            LOG.error("Unexpected error", e);
        }

    }

    private static void retrieveCourses(String authorId) {
        LOG.info("Retrieving courses for author '{}'", authorId);
    }
}
