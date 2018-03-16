package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBooktypeDAO;
import com.lib.model.LibBooktype;
import com.lib.model.vo.LibBooktypeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("libBooktypeDao")
public class LibBooktypeDAOImpl extends AbstractDAO<LibBooktype, LibBooktypeVO, String> implements LibBooktypeDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBooktypeDao";
}

    @Override
    public List<LibBooktypeVO> getPeopleNumList() {
        return sqlSessionTemplate.selectList(getNamespace()+"_EXT.getPeopleNumList");
    }
}
