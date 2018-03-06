package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibReadertypeDAO;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReadertypeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("libReadertypeDao")
public class  LibReadertypeDAOImpl extends AbstractDAO<LibReadertype, LibReadertypeVO, String> implements LibReadertypeDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libReadertypeDao";
}

    @Override
    public List<LibReadertypeVO> getPeopleNumList() {
        HashMap<String, Object> map = new HashMap<>();
        List<LibReadertypeVO> libReadertypeVOs = sqlSessionTemplate.selectList(getNamespace() + "_EXT.getPeopleNumList", map);
        return libReadertypeVOs;
    }
}
