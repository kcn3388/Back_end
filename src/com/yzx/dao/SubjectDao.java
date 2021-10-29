package com.yzx.dao;

import com.yzx.model.*;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class SubjectDao extends SqlSessionDaoSupport implements Dao<Subject> {
    @Override
    public List<Subject> selectAll() {
        return getSqlSession().selectList("com.yzx.mapper.SubjectMapper.selectAllSubjects");
    }

    @Override
    public Subject selectById(@Param("id") int id){
        return getSqlSession().selectOne("com.yzx.mapper.SubjectMapper.selectBySubjectId", id);
    }
}