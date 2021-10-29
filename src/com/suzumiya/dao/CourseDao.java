package com.suzumiya.dao;

import com.suzumiya.model.user.Course;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class CourseDao extends SqlSessionDaoSupport implements Dao<Course> {
    @Override
    public List<Course> selectAll() {
        return getSqlSession().selectList("com.yzx.mapper.CourseMapper.selectAll");
    }

    @Override
    public Course selectById(@Param("id") int id){
        return getSqlSession().selectOne("com.yzx.mapper.CourseMapper.selectByCourseId", id);
    }

}