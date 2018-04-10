package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookinfoDAO;
import com.lib.model.LibBookinfo;
import com.lib.model.vo.LibBookinfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository("libBookinfoDao")
public class LibBookinfoDAOImpl extends AbstractDAO<LibBookinfo, LibBookinfoVO, String> implements LibBookinfoDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBookinfoDao";
}

    @Override
    public List<LibBookinfoVO> getBookList(LibBookinfoVO libBookinfoVO, Integer pagesize, Integer page, String startTime, String endTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("condition",libBookinfoVO);
        map.put("start",pagesize*(page-1));
        map.put("end",pagesize);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.getBookList", map);
    }

    @Override
    public Integer getBookListTotal(LibBookinfoVO libBookinfoVO, String startTime, String endTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("condition",libBookinfoVO);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.getBookListTotal", map).size();
    }

    @Override
    public Integer countRecentBook(Date date) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("date",date);
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.countRecentBook", map).size();
    }

    @Override
    public Integer getEveryMothBorrow(Date start, Date end) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("start",start);
        map.put("end",end);
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.getEveryMothBorrow", map).size();
    }

    @Override
    public List<LibBookinfoVO> getNewFiveTop() {
        HashMap<String, Object> map = new HashMap<>();
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.getNewFiveTop", map);
    }
}
