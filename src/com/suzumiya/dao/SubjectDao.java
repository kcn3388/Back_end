package com.suzumiya.dao;

import com.suzumiya.model.*;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class SubjectDao extends SqlSessionDaoSupport implements Dao<Subject> {
    @Override
    public List<Subject> selectAll() {
        return getSqlSession().selectList("com.suzumiya.mapper.SubjectMapper.selectAllSubjects");
    }

    @Override
    public Subject selectById(@Param("id") int id){
        return getSqlSession().selectOne("com.suzumiya.mapper.SubjectMapper.selectBySubjectId", id);
    }
}