package com.yzx.controller;

import com.yzx.model.user.Course;
import com.yzx.service.CourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private CourseService service = (CourseService) ac.getBean("courseService");

    @RequestMapping(value = "/api/courses", method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public ModelAndView getAllCourses() {
        Map<String, List<Course>> map = service.getCoursesMap();
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }

    @RequestMapping(value = "/api/course", method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public ModelAndView getCourseBySid(@RequestParam(value = "id") int id) {
        Map<String, Course> map = service.getCourseMap(id);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }

}
