package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibReaderDAO;
import com.lib.model.LibReader;
import com.lib.model.vo.LibReaderVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("libReaderDao")
public class LibReaderDAOImpl extends AbstractDAO<LibReader, LibReaderVO, String> implements LibReaderDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libReaderDao";
}

    @Override
    public List<LibReaderVO> findBannerReader(LibReaderVO libReaderVO, Integer pagesize, Integer page,String startTime,String endTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("condition",libReaderVO);
        map.put("start",pagesize*(page-1));
        map.put("end",pagesize);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.findBannerReader",map);
    }

    @Override
    public int countCutoms(LibReaderVO libReaderVO,String startTime,String endTime) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("condition",libReaderVO);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.countCutoms",map).size();
    }
}
