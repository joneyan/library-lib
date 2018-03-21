package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookborrowDAO;
import com.lib.model.LibBookborrow;
import com.lib.model.vo.LibBookborrowVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
