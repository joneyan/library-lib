package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibReadertypeDAO;
import com.lib.model.LibReadertype;
import com.lib.model.vo.LibReadertypeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libReadertypeDao")
public class LibReadertypeDAOImpl extends AbstractDAO<LibReadertype, LibReadertypeVO, String> implements LibReadertypeDAO {
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
}
