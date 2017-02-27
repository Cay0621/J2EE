package org.com.cay.service;

import org.com.cay.entity.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

	Course getCourseById(Integer courseId);
}
