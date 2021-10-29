package com.yzx.service;

import com.alibaba.fastjson.JSONObject;
import com.yzx.dao.RedisDao;
import com.yzx.dao.SubjectDao;
import com.yzx.model.*;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectService {
    private List<Subject> subjects;

    private SubjectDao subjectDao;
    private Subject subject;

    private RedisDao redisDao;

    public SubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setRedisDao(RedisDao redisDao) {
        this.redisDao = redisDao;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    private void setSubjects() {
        this.subjects = subjectDao.selectAll();
    }

    private void setSubject(int s_id) {
        String subjectJson = redisDao.get("subject_" + s_id);
        if (StringUtils.isEmpty(subjectJson)) {
            this.subject = subjectDao.selectById(s_id);
            if (this.subject != null) {
                redisDao.set("subject_" + s_id, JSONObject.toJSONString(this.subject));
            }
        }
        else {
            this.subject = JSONObject.parseObject(subjectJson, Subject.class);
        }
    }

    public Map<String, List<Subject>> getSubjectsMap() {
        Map<String, List<Subject>> result = new HashMap<>();
        this.setSubjects();
        result.put("subjects", subjects);
        return result;
    }

    public Map<String, Subject> getSubjectMap(int id) {
        Map<String, Subject> result = new HashMap<>();
        setSubject(id);
        result.put("subject", subject);
        return result;
    }

}
