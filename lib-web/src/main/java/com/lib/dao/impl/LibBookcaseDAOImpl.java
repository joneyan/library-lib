package com.lib.dao.impl;

import com.lib.base.AbstractDAO;
import com.lib.dao.LibBookcaseDAO;
import com.lib.model.LibBookcase;
import com.lib.model.vo.LibBookcaseVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("libBookcaseDao")
public class LibBookcaseDAOImpl extends AbstractDAO<LibBookcase, LibBookcaseVO, String> implements LibBookcaseDAO {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
@Override
protected SqlSessionTemplate getSqlSessionTemplate() {
return sqlSessionTemplate;
}
@Override
protected String getNamespace() {
return "libBookcaseDao";
}
}
