package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookborrowDAO;
import com.lib.model.LibBookborrow;
import com.lib.model.vo.LibBookborrowVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository("libBookborrowDao")
public class LibBookborrowDAOImpl extends AbstractDAO<LibBookborrow, LibBookborrowVO, String> implements LibBookborrowDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBookborrowDao";
}

    @Override
    public List<LibBookborrowVO> gethaveBorrowList(Integer pageNumber, String name, int i) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("start",(pageNumber-1)*i);
        params.put("end",i);
        params.put("name",name);

        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.gethaveBorrowList",params);
    }

    @Override
    public Integer gethaveBorrowCount(String name) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("name",name);
        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.gethaveBorrowCount",params).size();
    }

    @Override
    public List<LibBookborrowVO> getBorrowListTopFive() {
        HashMap<String, Object> params = new HashMap<>();
        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.getBorrowListTopFive",params);
    }

    @Override
    public Integer getEveryMothBorrow(Date time, Date time1) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("start",time);
        map.put("end",time1);
        return sqlSessionTemplate.selectList(getNamespace() + "_EXT.getEveryMothBorrow", map).size();
    }
}
