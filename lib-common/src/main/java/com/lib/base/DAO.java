package com.lib.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface DAO<T, VO, PK extends Serializable> {
    void insert(T entity);

    T get(VO condition);
    T get(PK id);
    
    /**
     * 
     * @param cols 只查出指定列 格式如下：col1,col2,col3
     * @param id   指定id
     * @return
     */
    T get(String cols, PK id);

    List<T> find();

    List<T> find(OrderBy orderBy);
    /**
     *
     * @param cols 查找指定列的所有数据
     * @return
     */
    List<T> find(String cols);
    /**
     *
     * @param cols  查找指定列的数据并排序
     * @param orderBy
     * @return
     */
    List<T> find(String cols, OrderBy orderBy);
    List<T> find(int pageSize, int pageNumber);
    List<T> find(OrderBy orderBy, int pageSize, int pageNumber);
    List<T> find(VO condition);
    List<T> find(VO condition, OrderBy orderBy);
    List<T> find(VO condition, int pageSize, int pageNumber);
    List<T> find(VO condition, OrderBy orderBy, int pageSize, int pageNumber);
    List<T> find(String cols, VO condition, OrderBy orderBy, int pageSize, int pageNumber);
    List<T> findByIdList(List<PK> idList, VO condition, OrderBy orderBy);
    List<T> findByIdList(List<PK> idList, VO condition);
    List<T> findByIdList(List<PK> idList, OrderBy orderBy);
    List<T> findByIdList(List<PK> idList);

    int count();
    int count(String column);
    int count(VO condition);
    int count(VO condition, String column);

    Map<String, Object> aggregate(String[] functions, String[] columns);
    Map<String, Object> aggregate(VO condition, String[] functions, String[] columns);

    int update(T entity, VO condition);
    int update(T entity, PK id);
    int updateByIdList(T entity, List<PK> idList, VO condition);
    int updateByIdList(T entity, List<PK> idList);

    int update(Map<String, Object> entity, VO condition);
    int update(Map<String, Object> entity, PK id);
    int updateByIdList(Map<String, Object> entity, List<PK> idList, VO condition);
    int updateByIdList(Map<String, Object> entity, List<PK> idList);

    int remove(VO condition);
    int remove(PK id);
    int removeByIdList(List<PK> idList, VO condition);
    int removeByIdList(List<PK> idList);
}
