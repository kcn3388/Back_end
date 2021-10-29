package com.suzumiya.service;

import com.alibaba.fastjson.JSONObject;
import com.suzumiya.dao.RedisDao;
import com.suzumiya.dao.CourseDao;
import com.suzumiya.model.user.Course;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {
    private List<Course> courses;
    private CourseDao courseDao;
    private Course course;
    private RedisDao redisDao;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public RedisDao getRedisDao() {
        return redisDao;
    }

    public void setRedisDao(RedisDao redisDao) {
        this.redisDao = redisDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(int sid) {
        String courseJson = redisDao.get("course_" + sid);
        if (StringUtils.isEmpty(courseJson)) {
            this.course = courseDao.selectById(sid);
            if (this.course != null) {
                redisDao.set("course_" + sid, JSONObject.toJSONString(this.course));
            }
        }
        else {
            this.course = JSONObject.parseObject(courseJson, Course.class);
        }
    }

    public void setCourses() {
        this.courses = courseDao.selectAll();
    }

    public Map<String, List<Course>> getCoursesMap() {
        Map<String, List<Course>> result = new HashMap<>();
        this.setCourses();
        result.put("courses", courses);
        return result;
    }

    public Map<String, Course> getCourseMap(int id) {
        Map<String, Course> result = new HashMap<>();
        setCourse(id);
        result.put("course", course);
        return result;
    }


}
