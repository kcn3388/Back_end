package com.yzx.controller;


import com.yzx.model.*;
import com.yzx.service.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Map;

@Controller
public class SubjectController {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private SubjectService service = (SubjectService) ac.getBean("subjectService");

    @RequestMapping(value = "/api/subjects", method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public ModelAndView getAllSubjects() {
        Map<String, List<Subject>> map = service.getSubjectsMap();
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }

    @RequestMapping(value = "/api/subject", method = {RequestMethod.GET})
    @ResponseBody
    @CrossOrigin
    public ModelAndView getSubjectBySid(@RequestParam(value = "id") int id) {
        Map<String, Subject> map = service.getSubjectMap(id);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }


}
