package com.yzx.dao;

import java.util.List;

public interface Dao<T> {
    List<T> selectAll();
    T selectById(int id);
}
